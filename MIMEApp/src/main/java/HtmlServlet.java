import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet{
	static {
		System.out.println("Htmlservlet::Static Block:");
	}
	public HtmlServlet() {
		System.out.println("Htmlservlet:0 param constructor");
	}
	@Override
	public void init(ServletConfig cfg)throws ServletException{
		System.out.println("HtmlservletServelt Init(-,-)");
	   

}
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("htmlervelt service method::");
		//set response content tye[p
		res.setContentType("text/html");
		//get writer
		PrintWriter pw=res.getWriter();
		//write content response obj using printlwriter
		pw.println("<table border='1' bgcolor='cyan' align='center'>");
		pw.println("<tr><th>Ipl Team</th><th>Captin</th><th>Management</th></tr>");
		pw.println("<tr><td>MumbaiIndians</td><td>RhohitSharma</td><td>Reliance</td></tr>");
		pw.println("<tr><td>CHENNISuperKings</td><td>M.S.Dhoni</td><td>IndainCement</td></tr>");
		pw.println("<tr><td>RCB</td><th>KDuplisish</td><td>UBL</td></tr>");
		pw.println("<tr><td>GT</td><td>pandaya</td><td>CVS CAPTIALS</td></tr>");
		pw.println("<tr><td>SRH</td><td>Warner</td><td>Kavya</td><tr>");
		pw.println("</table>");
		
		//close stream
		pw.close();
	}//service(-,-);

}
