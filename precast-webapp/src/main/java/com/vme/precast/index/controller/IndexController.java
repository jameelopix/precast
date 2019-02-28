package com.vme.precast.index.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

@Controller
public class IndexController {

	String basePath = "C:/TEMP/";
	String inputfile = basePath + "input.pdf";
	String outputfile = basePath + "output.pdf";

	@RequestMapping("/")
	public String index() {
		String dest = "web/index.html";
		return dest;
	}

	@RequestMapping(value = "/pdf", method = RequestMethod.POST)
	public void downloadPDFResource(@RequestBody PdfDataWidgetModel widgetModel, HttpServletResponse response)
			throws IOException, DocumentException {

		File file1 = new File(outputfile);
		file1.getParentFile().mkdirs();

		this.processPDF(inputfile, outputfile, widgetModel);

		// Authorized user will download the file
//		String dataDirectory = request.getServletContext().getRealPath(basePath);
		String fileName = "output.pdf";

		Path file = Paths.get(basePath, fileName);
		if (Files.exists(file)) {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void processPDF(String src, String dest, PdfDataWidgetModel widgetModel)
			throws IOException, DocumentException {
		PdfReader reader = new PdfReader(src);
		PdfDictionary dict = reader.getPageN(1);
		PdfObject object = dict.getDirectObject(PdfName.CONTENTS);

		if (object instanceof PRStream) {
			PRStream stream = (PRStream) object;
			byte[] data = PdfReader.getStreamBytes(stream);
			String string = new String(data);
			string = string.replace("{{customerName}}", widgetModel.getCustomerName());
			string = string.replace("{{streetaddress}}", widgetModel.getStreetaddress());
			string = string.replace("{{city}}", widgetModel.getCity());
			string = string.replace("{{district}}", widgetModel.getDistrict());
			string = string.replace("{{state}}", widgetModel.getState());
			string = string.replace("{{country}}", widgetModel.getCountry());
			string = string.replace("{{pincode}}", widgetModel.getPincode());
			string = string.replace("{{empname}}", widgetModel.getDesignation());
			string = string.replace("{{designation}}", widgetModel.getEmpname());
			stream.setData(string.getBytes());
		}

		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
		stamper.close();
		reader.close();
	}
}
