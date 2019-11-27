/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import sun.misc.IOUtils;

/**
 * REST Web Service
 *
 * @author Wagner
 */
@Path("movimentos")
public class movimentos extends arquivo{
    @Context
    private UriInfo context;
       
         

    /**
     * Creates a new instance of movimentos
     */
    public movimentos() throws IOException {
    }

    /**
     * Retrieves representation of an instance of ws.movimentos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getXml() throws FileNotFoundException, IOException, InterruptedException{
                System.out.println("aaaaaaaaaaaa");
        String saida = Read();
        Write("");
             return saida;
    }

    /**
     * PUT method for updating or creating an instance of movimentos
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
  
 @POST
 @Consumes("application/json")
 @Produces("application/json")
  @Path("movimento/escrever")
 public void post(String content) throws IOException
 {
         Write(content);
 }

    
}
