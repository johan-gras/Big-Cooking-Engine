package bigcookingdata_engine.controller;

import java.io.*;
import java.util.*;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

@WebServlet("/RecoServlet")


public class RecoServlet extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 5000 * 1024;
   private int maxMemSize = 400 * 1024;
   private File file ;
   
   public static void main(String[] args) throws ClientProtocolException, IOException {
		callApi("test10.jpg");
	}

   public void init( ){
      // Get the file location where it would be stored.
      filePath = getServletContext().getInitParameter("file-upload"); 
      System.out.println(filePath);
   }
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
   
      // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
   
      if( !isMultipart ) {
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }
  
      DiskFileItemFactory factory = new DiskFileItemFactory();
   
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
   
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("/Users/utilisateur/git/BigCookingEngine/"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
   
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);
	
         // Process the uploaded file items
         Iterator i = fileItems.iterator();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
   
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               String contentType = fi.getContentType();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
               //System.out.println(file);
               
              // callApi
               String nameIngred = RecoServlet.callApi(file.toString()).toString();
               System.out.println(nameIngred);
               //out.println(RecoServlet.callApi(file.toString()));
               int id = 0;
               if(nameIngred.equals("Banana"))
            	   id = 9;
               if(nameIngred.equals("Apple"))
            	   id = 8;
               if(nameIngred.equals("Orange"))
            	   id = 34;
               if(nameIngred.equals("Ananas"))
            	   id = 273;
               if(nameIngred.equals("Apricot"))
            	   id = 347;
               if(nameIngred.equals("Cherry"))
            	   id = 87;
               if(nameIngred.equals("Grapefruit"))
            	   id = 124;
               if(nameIngred.equals("Lemon"))
            	   id = 65;
               if(nameIngred.equals("Melon"))
            	   id = 476 ;
               if(nameIngred.equals("Strawberry"))
            	   id = 283 ;
               
               
               
               
               Neo4J.addIngredientToFrigo(Integer.toString(id), Session.getInstance().getUser().getMail());
               
            }
         }
         out.println("</body>");
         out.println("</html>");
         } catch(Exception ex) {
            System.out.println(ex);
         }
      }
      
      public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, java.io.IOException {

         throw new ServletException("GET method used with " +
            getClass( ).getName( )+": POST method required.");
      }
      
      private static String callApi(String img) throws ClientProtocolException, IOException{
    	  HttpClient client = new DefaultHttpClient();
    	  HttpGet request = new HttpGet("http://127.0.0.1:5000/?path="+img+"");
    	  HttpResponse response = client.execute(request);
    	  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
    	  String line = "";
    	  line = rd.readLine();
    	  return line;
      }
}
