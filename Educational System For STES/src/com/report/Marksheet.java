/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.report;

import com.connection.Dbconn;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Marksheet {

   // public static String reportfile = "C:\\Users\\JP\\Desktop\\schoolreport\\";
    public static String pid = null, pname = null, gender = null, emailid = null, age = null, mobile = null, weight = null, address = null, height = null, dob = null;
     public static String id1 = "0", id2 = "0", id3 = "0", id4 = "0", id5 = "0", id6 = "0", id7 = "0", id8 = "0", id9 = "75", id10, id11, id12, id13, id14, id15;
    public static int sum1, sum2, sum3;
    public static double  percentage;
    public static String sub1,sub2,sub3,sub4,sub5,sub6,sub7;
    public static PdfPCell cella1,cella2,cella3,cella4,cella5,cella6,cella7,cella8,cella9,cella10,cella11,cella12,cella13,cella14,cella15,cella16,cella17,cella18,cella66,cella67,cella68,cella19,cella20,cella21;
    
    public static void createreport(String id,String msg,String studname) throws SQLException {

        Document doc = new Document();
        try {

            Connection con = Dbconn.conn();
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from studentdetails where id='" + id + "'");

            while (rs.next()) {
                pid = rs.getString("id");
                dob = rs.getString("classname");
                pname = rs.getString("name");
                address = rs.getString("addr");
                gender = rs.getString("gender");
            }

            Statement st2 = con.createStatement();
            ResultSet rs1 = st2.executeQuery("select * from tblmark where Student_ID='" + id + "' ");
            if(msg.equals("FE"))
            {
            	
            	if(rs1.next()) {
                    id1 = rs1.getString("Subject1");
                    id2 = rs1.getString("Subject2");
                    id3 = rs1.getString("Subject3");
                    id4 = rs1.getString("Subject4");
                    id5 = rs1.getString("Subject5");
                    sum1 = Integer.parseInt(id1) + Integer.parseInt(id2) + Integer.parseInt(id3) + Integer.parseInt(id4) + Integer.parseInt(id5);
                    id8=String.valueOf(sum1);
                    percentage=(double)(sum1*100)/500;
                }
            }
            else if(msg.equals("SE"))
            {
            	while (rs1.next()) {
                    id1 = rs1.getString("Subject1");
                    id2 = rs1.getString("Subject2");
                    id3 = rs1.getString("Subject3");
                    id4 = rs1.getString("Subject4");
                    id5 = rs1.getString("Subject5");
                    id6 = rs1.getString("Subject6");
                    id7 = rs1.getString("Subject7");
                    sum1 = Integer.parseInt(id1) + Integer.parseInt(id2) + Integer.parseInt(id3) + Integer.parseInt(id4) + Integer.parseInt(id5) + Integer.parseInt(id6) + Integer.parseInt(id7);
                    id8=String.valueOf(sum1);
                    percentage=(double)(sum1*100)/700;
                }
            }
            else if(msg.equals("TE"))
            {
            	while (rs1.next()) {
                    id1 = rs1.getString("Subject1");
                    id2 = rs1.getString("Subject2");
                    id3 = rs1.getString("Subject3");
                    id4 = rs1.getString("Subject4");
                    id5 = rs1.getString("Subject5");
                    id6 = rs1.getString("Subject6");
                    sum1 = Integer.parseInt(id1) + Integer.parseInt(id2) + Integer.parseInt(id3) + Integer.parseInt(id4) + Integer.parseInt(id5) + Integer.parseInt(id6);
                    id8=String.valueOf(sum1);
                    percentage=(double)(sum1*100)/600;
                }
            }
            else if(msg.equals("BE"))
            {
            	
            	while (rs1.next()) {
                    id1 = rs1.getString("Subject1");
                    id2 = rs1.getString("Subject2");
                    id3 = rs1.getString("Subject3");
                    id4 = rs1.getString("Subject4");
                    id5 = rs1.getString("Subject5");
                    id6 = rs1.getString("Subject6");
                    sum1 = Integer.parseInt(id1) + Integer.parseInt(id2) + Integer.parseInt(id3) + Integer.parseInt(id4) + Integer.parseInt(id5) + Integer.parseInt(id6);
                    id8=String.valueOf(sum1);
                    percentage=(double)(sum1*100)/600;
                }
            }
//            while (rs1.next()) {
//                id1 = rs1.getString("Subject1");
//                id2 = rs1.getString("Subject2");
//                id3 = rs1.getString("Subject3");
//                id4 = rs1.getString("Subject4");
//                id5 = rs1.getString("Subject5");
//                id6 = rs1.getString("Subject6");
//                id7 = rs1.getString("Subject7");
//            }
            
            DecimalFormat df = new DecimalFormat("00.00");
            id9=String.valueOf(df.format(percentage));
            if(percentage>=0&&percentage<=34)
            {
            id10="D";
            }
            else if(percentage>=35&&percentage<=44)
            {
            id10="C";
            }
            else if(percentage>=45&&percentage<=59)
            {
            id10="B";
            }
            else if(percentage>=60)
            {
            id10="A";
            }
            PdfWriter.getInstance(doc, new FileOutputStream(attendancemaster.reportfile +studname+"_Marks_Report_" + id + ".pdf"));
            doc.open();
            PdfPTable table1 = new PdfPTable(4);
            PdfPTable table2 = new PdfPTable(4);
            PdfPTable table3 = new PdfPTable(3);
            PdfPTable table4 = new PdfPTable(7);
            PdfPTable table5 = new PdfPTable(2);

            float[] columnWidthsa1 = {1f, 2.5f, 1f, 2.5f}; // Second column will be
            // twice as first and third
            table1.setWidths(columnWidthsa1);

            //Add Image
            Image image1 = Image.getInstance(Dbconn.logos);
            //Fixed Positioning
            image1.setAbsolutePosition(1f, 5f);
            //Scale to new height and new width of image
            image1.scaleAbsolute(50,45);
            //Add to document

            // Patient
            PdfPCell cell40 = new PdfPCell(image1);
            Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC | Font.UNDERLINE, BaseColor.RED);
            PdfPCell cellt40 = new PdfPCell(new Phrase("SKNSITS,Lonavala", redFont));
            PdfPCell cell41 = new PdfPCell(new Phrase("Student ID :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell42 = new PdfPCell(new Phrase(pid, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell59 = new PdfPCell(new Phrase("Student Name:", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell60 = new PdfPCell(new Phrase(pname, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell43 = new PdfPCell(new Phrase("Address :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell44 = new PdfPCell(new Phrase(address, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell61 = new PdfPCell(new Phrase("Gender :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell62 = new PdfPCell(new Phrase(gender, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell63 = new PdfPCell(new Phrase("Standard :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell64 = new PdfPCell(new Phrase(dob, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            Date day = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(day);
            PdfPCell cellt71 = new PdfPCell(new Phrase("Date :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cellt72 = new PdfPCell(new Phrase(strDate, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            cellt40.setColspan(3);

            cellt72.setColspan(3);
            //cellt40.setBorderColor(BaseColor.YELLOW);
            cell40.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellt40.setHorizontalAlignment(Element.TITLE);

            cell40.setBorder(Rectangle.NO_BORDER);
            cellt40.setBorder(Rectangle.NO_BORDER);
            cell41.setBorder(Rectangle.NO_BORDER);
            cell42.setBorder(Rectangle.NO_BORDER);
            cell59.setBorder(Rectangle.NO_BORDER);
            cell60.setBorder(Rectangle.NO_BORDER);

            cell43.setBorder(Rectangle.NO_BORDER);
            cell44.setBorder(Rectangle.NO_BORDER);
            cell63.setBorder(Rectangle.NO_BORDER);
            cell64.setBorder(Rectangle.NO_BORDER);
            cell61.setBorder(Rectangle.NO_BORDER);
            cell62.setBorder(Rectangle.NO_BORDER);
            cellt71.setBorder(Rectangle.NO_BORDER);
            cellt72.setBorder(Rectangle.NO_BORDER);
            table1.addCell(cell40);
            table1.addCell(cellt40);
            table1.addCell(cell41);
            table1.addCell(cell42);
            table1.addCell(cell59);
            table1.addCell(cell60);
            table1.addCell(cell43);
            table1.addCell(cell44);
            table1.addCell(cell63);
            table1.addCell(cell64);
            table1.addCell(cell61);
            table1.addCell(cell62);
            table1.addCell(cellt71);
            table1.addCell(cellt72);
            table1.setSpacingAfter(20);
            // Set Column widths of table
            float[] columnWidthsa = {2.0f, 2.2f, 2.5f}; // Second column will be
            // twice as first and third
            table3.setWidths(columnWidthsa);
//Font whiteFont = new FontFactory;
            PdfPCell cellt1 = new PdfPCell(new Phrase("Subject", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
            PdfPCell cellt2 = new PdfPCell(new Phrase("Maximum Marks", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
            PdfPCell cellt4 = new PdfPCell(new Phrase("Marks Obtened", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
          
            if(msg.equals("FE"))
            {
            	sub1="English";
            	sub2="Hindi";
            	sub3="Maths";
            	sub4="Gk";
            	sub5="Mar";
            	 cella1 = new PdfPCell(new Phrase(sub1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella2 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella3 = new PdfPCell(new Phrase(id1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella4 = new PdfPCell(new Phrase(sub2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella5 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella6 = new PdfPCell(new Phrase(id2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella7 = new PdfPCell(new Phrase(sub3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella8 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella9 = new PdfPCell(new Phrase(id3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella10 = new PdfPCell(new Phrase(sub4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                cella11 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella12 = new PdfPCell(new Phrase(id4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                 cella13 = new PdfPCell(new Phrase(sub5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                cella14 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
              cella15 = new PdfPCell(new Phrase(id5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
              cella19 = new PdfPCell(new Phrase("Total Marks", FontFactory.getFont(FontFactory.HELVETICA, 8)));
              cella20 = new PdfPCell(new Phrase("500", FontFactory.getFont(FontFactory.HELVETICA, 8)));
              cella21 = new PdfPCell(new Phrase(id8, FontFactory.getFont(FontFactory.HELVETICA, 8)));

}
else if(msg.equals("SE"))
            {
	sub1="English";
	sub2="Hindi";
	sub3="Maths";
	sub4="Gk";
	sub5="SST";
	sub6="Sanskrit";
	sub7="Science";
	cella1 = new PdfPCell(new Phrase(sub1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella2 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella3 = new PdfPCell(new Phrase(id1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella4 = new PdfPCell(new Phrase(sub2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella5 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella6 = new PdfPCell(new Phrase(id2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella7 = new PdfPCell(new Phrase(sub3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella8 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella9 = new PdfPCell(new Phrase(id3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella10 = new PdfPCell(new Phrase(sub4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
   cella11 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella12 = new PdfPCell(new Phrase(id4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella13 = new PdfPCell(new Phrase(sub5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
   cella14 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
 cella15 = new PdfPCell(new Phrase(id5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella16 = new PdfPCell(new Phrase(sub6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella17 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella18 = new PdfPCell(new Phrase(id6, FontFactory.getFont(FontFactory.HELVETICA, 8)));

    cella66 = new PdfPCell(new Phrase(sub7, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella67 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella68 = new PdfPCell(new Phrase(id7, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella19 = new PdfPCell(new Phrase("Total Marks", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella20 = new PdfPCell(new Phrase("700", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella21 = new PdfPCell(new Phrase(id8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            }
else if(msg.equals("TE"))
            {
	sub1="English";
	sub2="Hindi";
	sub3="Maths";
	sub4="Physics";
	sub5="Chemistry";
	sub6="Biology";
	cella1 = new PdfPCell(new Phrase(sub1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella2 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella3 = new PdfPCell(new Phrase(id1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella4 = new PdfPCell(new Phrase(sub2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella5 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella6 = new PdfPCell(new Phrase(id2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella7 = new PdfPCell(new Phrase(sub3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella8 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella9 = new PdfPCell(new Phrase(id3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella10 = new PdfPCell(new Phrase(sub4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
   cella11 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella12 = new PdfPCell(new Phrase(id4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella13 = new PdfPCell(new Phrase(sub5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
   cella14 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
 cella15 = new PdfPCell(new Phrase(id5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella16 = new PdfPCell(new Phrase(sub6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella17 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella18 = new PdfPCell(new Phrase(id6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella19 = new PdfPCell(new Phrase("Total Marks", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella20 = new PdfPCell(new Phrase("600", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella21 = new PdfPCell(new Phrase(id8, FontFactory.getFont(FontFactory.HELVETICA, 8)));

               }
else if(msg.equals("BE"))
            {
	sub1="English";
	sub2="Hindi";
	sub3="Maths";
	sub4="Physics";
	sub5="Chemistry";
	sub6="Biology";
	cella1 = new PdfPCell(new Phrase(sub1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella2 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella3 = new PdfPCell(new Phrase(id1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella4 = new PdfPCell(new Phrase(sub2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella5 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella6 = new PdfPCell(new Phrase(id2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella7 = new PdfPCell(new Phrase(sub3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella8 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella9 = new PdfPCell(new Phrase(id3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella10 = new PdfPCell(new Phrase(sub4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
   cella11 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella12 = new PdfPCell(new Phrase(id4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella13 = new PdfPCell(new Phrase(sub5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
   cella14 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
 cella15 = new PdfPCell(new Phrase(id5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella16 = new PdfPCell(new Phrase(sub6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella17 = new PdfPCell(new Phrase("100", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella18 = new PdfPCell(new Phrase(id6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella19 = new PdfPCell(new Phrase("Total Marks", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella20 = new PdfPCell(new Phrase("600", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    cella21 = new PdfPCell(new Phrase(id8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            }
            PdfPCell cella22 = new PdfPCell(new Phrase("Percentage", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella23 = new PdfPCell(new Phrase(id9, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cella22.setColspan(2);

            PdfPCell cella24 = new PdfPCell(new Phrase("Result(Grade)", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella25 = new PdfPCell(new Phrase(id10, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cella24.setColspan(2);

            PdfPCell cella48 = new PdfPCell(new Phrase("Grades Of Certification", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cella48.setColspan(4);
            PdfPCell cella26 = new PdfPCell(new Phrase("Grade I with Distination", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella27 = new PdfPCell(new Phrase("Grade I", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella28 = new PdfPCell(new Phrase("Grade II", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella29 = new PdfPCell(new Phrase("Grade", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella30 = new PdfPCell(new Phrase("75% & above", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella31 = new PdfPCell(new Phrase("60% & above but below 75%", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella32 = new PdfPCell(new Phrase("45% & above but below 60%", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella33 = new PdfPCell(new Phrase("All other successful candidate", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella49 = new PdfPCell(new Phrase("Grades In Work Experience/School Subject", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cella49.setColspan(7);
            PdfPCell cella34 = new PdfPCell(new Phrase("Grade", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella35 = new PdfPCell(new Phrase("A", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella36 = new PdfPCell(new Phrase("B", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella37 = new PdfPCell(new Phrase("C", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella38 = new PdfPCell(new Phrase("D", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella39 = new PdfPCell(new Phrase("E", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella40 = new PdfPCell(new Phrase("H", FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cella41 = new PdfPCell(new Phrase("Marks Obtained", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella42 = new PdfPCell(new Phrase("60% & above", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella43 = new PdfPCell(new Phrase("45% to 59%", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella44 = new PdfPCell(new Phrase("35% to 44%", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella45 = new PdfPCell(new Phrase("34% & below", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella46 = new PdfPCell(new Phrase("Exempted", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella47 = new PdfPCell(new Phrase("Physically Handicapped", FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cella59 = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella60 = new PdfPCell(new Phrase("Teacher Name", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            //  cella59.setColspan(2);

            PdfPCell cella61 = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella62 = new PdfPCell(new Phrase("Sign", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cella60.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cella62.setHorizontalAlignment(Element.ALIGN_RIGHT);

            cella59.setBorder(Rectangle.NO_BORDER);
            cella60.setBorder(Rectangle.NO_BORDER);
            cella61.setBorder(Rectangle.NO_BORDER);
            cella62.setBorder(Rectangle.NO_BORDER);
            table3.addCell(cellt1);
            table3.addCell(cellt2);
            table3.addCell(cellt4);
            if(msg.equals("FE"))
            {
            	table3.addCell(cella1);
                table3.addCell(cella2);
                table3.addCell(cella3);
                table3.addCell(cella4);
                table3.addCell(cella5);
                table3.addCell(cella6);
                table3.addCell(cella7);
                table3.addCell(cella8);
                table3.addCell(cella9);
                table3.addCell(cella10);
                table3.addCell(cella11);
                table3.addCell(cella12);
                table3.addCell(cella13);
                table3.addCell(cella14);
                table3.addCell(cella15);
                table3.addCell(cella19);
                table3.addCell(cella20);
                table3.addCell(cella21);
}
else if(msg.equals("SE"))
            {
	table3.addCell(cella1);
    table3.addCell(cella2);
    table3.addCell(cella3);
    table3.addCell(cella4);
    table3.addCell(cella5);
    table3.addCell(cella6);
    table3.addCell(cella7);
    table3.addCell(cella8);
    table3.addCell(cella9);
    table3.addCell(cella10);
    table3.addCell(cella11);
    table3.addCell(cella12);
    table3.addCell(cella13);
    table3.addCell(cella14);
    table3.addCell(cella15);
    table3.addCell(cella16);
    table3.addCell(cella17);
    table3.addCell(cella18);
    table3.addCell(cella66);
  table3.addCell(cella67);
  table3.addCell(cella68);
  table3.addCell(cella19);
  table3.addCell(cella20);
  table3.addCell(cella21);
            }
else if(msg.equals("TE"))
            {
	table3.addCell(cella1);
    table3.addCell(cella2);
    table3.addCell(cella3);
    table3.addCell(cella4);
    table3.addCell(cella5);
    table3.addCell(cella6);
    table3.addCell(cella7);
    table3.addCell(cella8);
    table3.addCell(cella9);
    table3.addCell(cella10);
    table3.addCell(cella11);
    table3.addCell(cella12);
    table3.addCell(cella13);
    table3.addCell(cella14);
    table3.addCell(cella15);

  table3.addCell(cella16);
  table3.addCell(cella17);
  table3.addCell(cella18);
  table3.addCell(cella19);
  table3.addCell(cella20);
  table3.addCell(cella21);
            }
else if(msg.equals("BE"))
            {
	table3.addCell(cella1);
    table3.addCell(cella2);
    table3.addCell(cella3);
    table3.addCell(cella4);
    table3.addCell(cella5);
    table3.addCell(cella6);
    table3.addCell(cella7);
    table3.addCell(cella8);
    table3.addCell(cella9);
    table3.addCell(cella10);
    table3.addCell(cella11);
    table3.addCell(cella12);
    table3.addCell(cella13);
    table3.addCell(cella14);
    table3.addCell(cella15);
  table3.addCell(cella16);
  table3.addCell(cella17);
  table3.addCell(cella18);
  table3.addCell(cella19);
  table3.addCell(cella20);
  table3.addCell(cella21);
            }
            
//            table3.addCell(cella16);
//            table3.addCell(cella17);
//            table3.addCell(cella18);
//            table3.addCell(cella66);
//            table3.addCell(cella67);
//            table3.addCell(cella68);

           
            table3.addCell(cella22);
            table3.addCell(cella23);

            table3.addCell(cella24);
            table3.addCell(cella25);
            table3.setSpacingAfter(20);
            cella48.setHorizontalAlignment(Element.ALIGN_LEFT);
            cella48.setHorizontalAlignment(Element.TITLE);
            table2.addCell(cella48);
            table2.addCell(cella26);
            table2.addCell(cella27);
            table2.addCell(cella28);
            table2.addCell(cella29);
            table2.addCell(cella30);
            table2.addCell(cella31);
            table2.addCell(cella32);
            table2.addCell(cella33);
//

            cella49.setHorizontalAlignment(Element.ALIGN_LEFT);
            cella49.setHorizontalAlignment(Element.TITLE);
            table2.setSpacingAfter(20);
            table4.addCell(cella49);
            table4.addCell(cella34);
            table4.addCell(cella35);

            table4.addCell(cella36);
            table4.addCell(cella37);
            table4.addCell(cella38);
            table4.addCell(cella39);

            table4.addCell(cella40);
            table4.addCell(cella41);

            table4.addCell(cella42);
            table4.addCell(cella43);

            table4.addCell(cella44);
            table4.addCell(cella45);
            table4.addCell(cella46);
            table4.addCell(cella47);
            table4.setSpacingAfter(24);

            table5.addCell(cella59);
            table5.addCell(cella60);
            table5.addCell(cella61);
            table5.addCell(cella62);
            doc.add(table1);
            doc.add(table3);
            doc.add(table2);
            doc.add(table4);
            doc.add(table5);

        } catch (DocumentException | IOException e) {
        	System.out.println(e);
        } catch (ClassNotFoundException ex) {
           System.out.println(ex);
        } finally {
            doc.close();
        }

    }

    public static void main(String[] args) throws IOException, DocumentException, SQLException {
//        createreport("2");
    }

}
