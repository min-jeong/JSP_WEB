/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-06 09:34:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.team.vo.TeamVO;

public final class chat_005fmem_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1459327742000L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/workspace/JSP_WEB/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project-Front/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.ktds.pingpong.chat.biz.ChatBiz");
    _jspx_imports_classes.add("com.ktds.pingpong.team.vo.TeamVO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<style>\r\n");
      out.write("::-webkit-scrollbar {width: 8px; height: 8px; border: 3px solid #fff; }\r\n");
      out.write("::-webkit-scrollbar-button:start:decrement, ::-webkit-scrollbar-button:end:increment {display: block; height: 10px; background: url('./images/bg.png') #efefef}\r\n");
      out.write("::-webkit-scrollbar-track {background: #efefef; -webkit-border-radius: 10px; border-radius:10px; -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,.2)}\r\n");
      out.write("::-webkit-scrollbar-thumb {height: 50px; width: 50px; background: rgba(0,0,0,.2); -webkit-border-radius: 8px; border-radius: 8px; -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,.1)}\r\n");
      out.write("html{scrollbar-3dLight-Color: #efefef; scrollbar-arrow-color: #dfdfdf; scrollbar-base-color: #efefef; scrollbar-Face-Color: #dfdfdf; scrollbar-Track-Color: #efefef; scrollbar-DarkShadow-Color: #efefef; scrollbar-Highlight-Color: #efefef; scrollbar-Shadow-Color: #efefef;}\r\n");
      out.write("#myProgress {\r\n");
      out.write("background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);\r\n");
      out.write("  background-image: -o-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);\r\n");
      out.write("  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);\r\n");
      out.write("  background-size: 40px 40px;\r\n");
      out.write("    /*  height: 20px; \r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tbackground: #555;\r\n");
      out.write("\t-moz-border-radius: 25px;\r\n");
      out.write("\t-webkit-border-radius: 25px;\r\n");
      out.write("\tborder-radius: 25px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tbox-shadow: inset 0 -1px 1px rgba(255,255,255,0.3);  */\r\n");
      out.write("/*   background-color: #eee;\r\n");
      out.write("  border-radius: 2px;\r\n");
      out.write("  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.25) inset; */\r\n");
      out.write("}\r\n");
      out.write("#myBar {\r\n");
      out.write(" background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);\r\n");
      out.write("  background-image: -o-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);\r\n");
      out.write("  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);\r\n");
      out.write("background-color: #f44336;\r\n");
      out.write("  /*     content: \"\";\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  top: 0; left: 0; bottom: 0; right: 0;\r\n");
      out.write("  background-image: linear-gradient(\r\n");
      out.write("    -45deg, \r\n");
      out.write("    rgba(255, 255, 255, .2) 25%, \r\n");
      out.write("    transparent 25%, \r\n");
      out.write("    transparent 50%, \r\n");
      out.write("    rgba(255, 255, 255, .2) 50%, \r\n");
      out.write("    rgba(255, 255, 255, .2) 75%, \r\n");
      out.write("    transparent 75%, \r\n");
      out.write("    transparent\r\n");
      out.write("  );\r\n");
      out.write("  z-index: 1;\r\n");
      out.write("  background-size: 50px 50px;\r\n");
      out.write("  animation: move 2s linear infinite;\r\n");
      out.write("  border-top-right-radius: 8px;\r\n");
      out.write("  border-bottom-right-radius: 8px;\r\n");
      out.write("  border-top-left-radius: 20px;\r\n");
      out.write("  border-bottom-left-radius: 20px;\r\n");
      out.write("  overflow: hidden;  */\r\n");
      out.write("/*   background-image:\r\n");
      out.write("\t   -webkit-linear-gradient(-45deg, \r\n");
      out.write("\t                           transparent 33%, rgba(0, 0, 0, .1) 33%, \r\n");
      out.write("\t                           rgba(0,0, 0, .1) 66%, transparent 66%),\r\n");
      out.write("\t   -webkit-linear-gradient(top, \r\n");
      out.write("\t                           rgba(255, 255, 255, .25), \r\n");
      out.write("\t                           rgba(0, 0, 0, .25)),\r\n");
      out.write("\t   -webkit-linear-gradient(left, #09c, #f44);\r\n");
      out.write("\r\n");
      out.write("    border-radius: 2px; \r\n");
      out.write("    background-size: 35px 20px, 100% 100%, 100% 100%; */\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#myProgress\").hide();\r\n");
      out.write("\t$(\"#myBar\").hide();\r\n");
      out.write("\t  \r\n");
      out.write("\t $(\"#upload\").click( function move() {\r\n");
      out.write("\t    $(\"#myProgress\").show();\r\n");
      out.write("\t\t$(\"#myBar\").show();\r\n");
      out.write("\t\tvar elem = document.getElementById(\"myBar\"); \r\n");
      out.write("\t    var width = 0;\r\n");
      out.write("\t    var id = setInterval(frame, 180);\r\n");
      out.write("\t    function frame() {\r\n");
      out.write("\t        if (width >= 100) {\r\n");
      out.write("\t            clearInterval(id);\r\n");
      out.write("\t        } else {\r\n");
      out.write("\t            width++; \r\n");
      out.write("\t            elem.style.width = width + '%'; \r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("}); \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"card\">\r\n");
      out.write("\t<div class=\"card-header\" style=\"background-color: #71d1b2;\">\r\n");
      out.write("\t    <h2>Text Diary by Member\r\n");
      out.write("\t     <button type=\"button\" class=\"md md-help\" data-trigger=\"hover\" data-toggle=\"popover\" data-placement=\"bottom\" data-content=\"대화방에 존재하는 멤버별 대화 추출\"  style=\"border-radius :50%; background-color: #71d1b2; border: 0; size: 50%;\"></button>\r\n");
      out.write("\t    </h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"card-body card-padding\">\r\n");
      out.write("\t<!-- <div class=\"row\">\r\n");
      out.write("\t    <div class=\"col-sm-4\">\r\n");
      out.write("\t        <p class=\"f-500 c-black m-b-20\">Input only text file</p>\r\n");
      out.write("\t        <form id=\"textFileUpload\" method=\"post\" action=\"/insertChat\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t        <div class=\"fileinput fileinput-new\" data-provides=\"fileinput\">\r\n");
      out.write("\t            <span class=\"btn btn-primary btn-file m-r-10\">\r\n");
      out.write("\t                <span class=\"fileinput-new\">Select file</span>\r\n");
      out.write("\t                <span class=\"fileinput-exists\">Change</span>\r\n");
      out.write("\t                <input type=\"file\" name=\"chatText\" value=\"file\">\r\n");
      out.write("\t            </span>\r\n");
      out.write("\t            <span class=\"fileinput-filename\" style=\"color: black;\"></span>\r\n");
      out.write("\t            <a href=\"#\" class=\"close fileinput-exists\" data-dismiss=\"fileinput\" style=\"color: black;\">&times;</a>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <br/>\r\n");
      out.write("\t        <button class=\"btn bgm-red\" type=\"submit\" id=\"upload\"><i class=\"md md-trending-up\" style=\" margin-bottom: 2px;\"></i> Upload TextFile</button>\r\n");
      out.write("\t        <br/>\r\n");
      out.write("\t        <div id=\"myProgress\">\r\n");
      out.write("\t\t\t\t  <div id=\"myBar\">\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t        </form>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</div> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"panel-group\" role=\"tablist\" data-collapse-color=\"amber\" aria-multiselectable=\"true\">\r\n");
      out.write("    <div class=\"panel panel-collapse\">\r\n");
      out.write("        <div class=\"panel-heading\" role=\"tab\" id=\"headingOne\">\r\n");
      out.write("            <h4 class=\"panel-title\"  >\r\n");
      out.write("                <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\r\n");
      out.write("                  Member List\r\n");
      out.write("              </a>\r\n");
      out.write("          </h4>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"collapseOne\" class=\"collapse in\" role=\"tabpanel\" aria-labelledby=\"headingOne\">\r\n");
      out.write("          <div class=\"panel-body\">\r\n");
      out.write("          \t <form id=\"getNickName\" method=\"post\" action=\"/getChat\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t  </form>\r\n");
      out.write("           </div>\r\n");
      out.write("       </div>\r\n");
      out.write("   </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("  </div>     \r\n");
      out.write("</div>\t\r\n");
      out.write("                                \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/chat/chat_mem.jsp(139,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ allChatMember }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/view/chat/chat_mem.jsp(139,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("mem");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<a href=\"/getChat?nickName=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ mem }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t\t<div class=\"listview lv-user m-t-20\">\r\n");
          out.write("\t\t\t\t\t<div class=\"lv-item media\">\r\n");
          out.write("\t\t\t\t    <div class=\"lv-avatar pull-left\" style=\"background-color: #ff4f3e;\">m</div>\r\n");
          out.write("\t\t\t\t    <div class=\"media-body\">\r\n");
          out.write("\t\t\t\t        <div class=\"lv-title\" style=\"margin-top: 4px; font-size:13px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ mem }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t     </div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
