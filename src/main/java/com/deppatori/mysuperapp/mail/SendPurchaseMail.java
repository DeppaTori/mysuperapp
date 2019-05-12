package com.deppatori.mysuperapp.mail;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.deppatori.mysuperapp.format.RupiahFormat;
import com.deppatori.mysuperapp.model.Purchase;

@Component
public class SendPurchaseMail{
	
	@Value("${deppatori.mail.account}")
	private String emailAddress;
	
	@Value("${deppatori.mail.password}")
	private String password;
	
	@Autowired
	private RupiahFormat rupiahFormat;
	
	public void send(Purchase purchase) throws AddressException,MessagingException,IOException{
		Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(emailAddress,password);
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(this.emailAddress, false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(purchase.getCustomer().getEmail()));
		   msg.setSubject("Transaksi di Deppatori Shop");
		   msg.setContent(this.getMailContent(purchase), "text/html");
		   msg.setSentDate(new Date());

		   Transport.send(msg);
	}
	
	public String getMailContent(Purchase purchase) {
		String pattern = "dd/MM/YYYY hh:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String purchaseDate = simpleDateFormat.format(purchase.getPurchaseDate());
		String customerName = purchase.getCustomer().getFirstName().concat(" ").concat(purchase.getCustomer().getLastName());
		
		String html,html2,html3,htmlPembayaran = "";
		
		
		
		
		String html1 = "<html><body>"+
				"<p>Halo, <b>"+customerName+" </b></p> \r\n"+
				"<p>Terima kasih telah berbelanja di Deppatori.com</p> \r\n"+
				"\r\n"+
				"\r\n"+
				"<h3>Pesanan Anda</h3> <hr/> \r\n"+
				"<table>\r\n" + 
				"  <tr>\r\n" + 
				"    <th align=\"left\">NO. Pesanan</th>\r\n" + 
				"    <th>TANGGAL PESANAN</th> \r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td width=\"300\">"+purchase.getPurchaseNo()+"</td>\r\n" + 
				"    <td>"+purchaseDate+"</td> \r\n" +  
				"  </tr>\r\n" + 
				"</table>";
				
		
		htmlPembayaran  =  " <p>\r\n"+
				" RINCIAN PEMBAYARAN <br/> \r\n" + 
				 "<b>Total Pembayaran </b>"+rupiahFormat.format(purchase.getTotalHarga())+" <br/> \r\n" + 
				"</p> \r\n"+
			
				"<br/> \r\n"+
				"<h3>Produk</h3> <hr/> \r\n";
				
		
		html2 = purchase.getPurchaseDetails().stream().map(produkDetail->{
			return "<p>\r\n"+
					"<b>"+produkDetail.getProduk().getNama()+"</b> <br/> \r\n"+
					" "+rupiahFormat.format(produkDetail.getProduk().getHarga())+" /unit <br/> \r\n"+
					"Jumlah: "+produkDetail.getJumlah()+" \r\n"+
					"\r\n"+
					"\r\n"+
					"</p>\r\n";
		}).collect(Collectors.joining(" "));
		
		html3 =  "<hr/> <p>\r\n"+
				"ALAMAT PENGIRIMAN <br/> \r\n" + 
				 customerName+" <br/> \r\n" + 
				purchase.getCustomer().getAddress1()+" <br/> \r\n" + 
				purchase.getCustomer().getAddress2()+" <br/> \r\n" + 
				purchase.getCustomer().getCity()+" <br/> \r\n" + 
				"</p> \r\n"+
				"</body></html>";
		
		html = html1.concat(htmlPembayaran).concat(html2).concat(html3);
		
		return html;
	}
}
