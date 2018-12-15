package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>首页</title>\r\n");
      out.write("<style>\r\n");
      out.write("    *{\r\n");
      out.write("    padding:0;\r\n");
      out.write("    margin:0;\r\n");
      out.write("    font-family:\"微软雅黑\";\r\n");
      out.write("}\r\n");
      out.write(".header{\r\n");
      out.write("    height:72px;\r\n");
      out.write("    background:#458fce ;\r\n");
      out.write("}\r\n");
      out.write(".header .logo{\r\n");
      out.write("    color:#fff ;\r\n");
      out.write("    line-height:70px;\r\n");
      out.write("    font-size:30px;\r\n");
      out.write("    margin-left:20px;\r\n");
      out.write("    display:inline-block;\r\n");
      out.write("    text-align:center;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("a {\r\n");
      out.write("    color: #fff ;\r\n");
      out.write("    text-decoration: none ;\r\n");
      out.write("}\r\n");
      out.write(".header .login{\r\n");
      out.write("    float:right;\r\n");
      out.write("    color:#fff ;\r\n");
      out.write("    line-height:72px;\r\n");
      out.write("    margin-right:2px;\r\n");
      out.write("    display:inline-block;\r\n");
      out.write("}\r\n");
      out.write(".banner{\r\n");
      out.write("    height:380px;\r\n");
      out.write("    overflow:hidden;\r\n");
      out.write("    background: #ddd;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"logo\">web实践</div>\r\n");
      out.write("        <div class =\"login\">\r\n");
      out.write("            <a href =\"javascript:void(0)\">登录</a>\r\n");
      out.write("            <span>|</span> \r\n");
      out.write("            <a href =\"javascript:void(0)\">故事</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
