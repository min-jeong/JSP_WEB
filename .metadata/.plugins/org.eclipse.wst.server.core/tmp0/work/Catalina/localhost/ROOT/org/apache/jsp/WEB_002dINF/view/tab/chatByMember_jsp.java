/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-01 04:35:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.tab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chatByMember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1459327743668L));
    _jspx_dependants.put("jar:file:/C:/Users/206-001/workspace/JSP_WEB/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project-Front/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>PingPong Chat</title>\r\n");
      out.write("        <!-- Vendor CSS -->\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/animate-css/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/fullcalendar/fullcalendar.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/sweet-alert/sweet-alert.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/light-gallery/lightGallery.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/material-icons/material-design-iconic-font.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/socicon/socicon.min.css\" rel=\"stylesheet\">\r\n");
      out.write("            \r\n");
      out.write("        <!-- CSS -->\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/css/app.min.1.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/css/app.min.2.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/css/display.property.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/css/profile.css\" rel=\"stylesheet\">\r\n");
      out.write("   \t    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/light-gallery/hovereffect.css\" rel=\"stylesheet\">\r\n");
      out.write("   \t    \r\n");
      out.write("   \t    <!-- Scrollbar CSS, Script -->\r\n");
      out.write("   \t    <link rel=\"stylesheet\" href=\"resource/css/jquery.mCustomScrollbar.css\" />\r\n");
      out.write("   \t    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"/resource/js/jquery.mCustomScrollbar.concat.min.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("        <!-- Javascript Libraries -->\r\n");
      out.write("        <script src=\"resource/js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("        <script src=\"resource/js/bootstrap.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"resource/vendors/nicescroll/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("        <script src=\"resource/vendors/auto-size/jquery.autosize.min.js\"></script>\r\n");
      out.write("        <script src=\"resource/vendors/waves/waves.min.js\"></script>\r\n");
      out.write("        <script src=\"resource/vendors/bootgrid/jquery.bootgrid.min.js\"></script>\r\n");
      out.write("        <script src=\"resource/vendors/bootstrap-growl/bootstrap-growl.min.js\"></script>\r\n");
      out.write("        <script src=\"resource/vendors/sweet-alert/sweet-alert.min.js\"></script>\r\n");
      out.write("     \t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/resourcevendors/fileinput/fileinput.min.js\"></script>\r\n");
      out.write("     \t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/chosen/chosen.jquery.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/bootstrap-select/bootstrap-select.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/bootstrap-wizard/jquery.bootstrap.wizard.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"resource/js/functions.js\"></script>\r\n");
      out.write("        <script src=\"resource/js/demo.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function(){\r\n");
      out.write("                //Basic Example\r\n");
      out.write("                $(\"#data-table-basic\").bootgrid({\r\n");
      out.write("                    css: {\r\n");
      out.write("                        icon: 'md icon',\r\n");
      out.write("                        iconColumns: 'md-view-module',\r\n");
      out.write("                        iconDown: 'md-expand-more',\r\n");
      out.write("                        iconRefresh: 'md-refresh',\r\n");
      out.write("                        iconUp: 'md-expand-less'\r\n");
      out.write("                    },\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                $(\"#upload\").click( function move() {\r\n");
      out.write("\t\t\t\t\tvar elem = document.getElementById(\"myBar\"); \r\n");
      out.write("\t\t\t\t    var width = 0;\r\n");
      out.write("\t\t\t\t    var id = setInterval(frame, 180);\r\n");
      out.write("\t\t\t\t    function frame() {\r\n");
      out.write("\t\t\t\t        if (width >= 100) {\r\n");
      out.write("\t\t\t\t            clearInterval(id);\r\n");
      out.write("\t\t\t\t        } else {\r\n");
      out.write("\t\t\t\t            width++; \r\n");
      out.write("\t\t\t\t            elem.style.width = width + '%'; \r\n");
      out.write("\t\t\t\t        }\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("<style>\r\n");
      out.write("::-webkit-scrollbar {width: 8px; height: 8px; border: 3px solid #fff; }\r\n");
      out.write("::-webkit-scrollbar-button:start:decrement, ::-webkit-scrollbar-button:end:increment {display: block; height: 10px; background: url('./images/bg.png') #efefef}\r\n");
      out.write("::-webkit-scrollbar-track {background: #efefef; -webkit-border-radius: 10px; border-radius:10px; -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,.2)}\r\n");
      out.write("::-webkit-scrollbar-thumb {height: 50px; width: 50px; background: rgba(0,0,0,.2); -webkit-border-radius: 8px; border-radius: 8px; -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,.1)}\r\n");
      out.write("html{scrollbar-3dLight-Color: #efefef; scrollbar-arrow-color: #dfdfdf; scrollbar-base-color: #efefef; scrollbar-Face-Color: #dfdfdf; scrollbar-Track-Color: #efefef; scrollbar-DarkShadow-Color: #efefef; scrollbar-Highlight-Color: #efefef; scrollbar-Shadow-Color: #efefef;}\r\n");
      out.write("#myProgress {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    background-color: white;\r\n");
      out.write("}\r\n");
      out.write("#myBar {\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    width: 1%;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    background-color: green;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f3(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("<body id=\"content\">\r\n");
      out.write("       <header id=\"header\">\r\n");
      out.write("            <ul class=\"header-inner\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <div class=\"line-wrap\">\r\n");
      out.write("                        <div class=\"line top\"></div>\r\n");
      out.write("                        <div class=\"line center\"></div>\r\n");
      out.write("                        <div class=\"line bottom\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("            \r\n");
      out.write("                <li class=\"logo hidden-xs\">\r\n");
      out.write("                    <a class=\"orgin\" href=\"/goMain\">PingPong Chat</a>\r\n");
      out.write("                </li>\r\n");
      out.write("               \t\t \r\n");
      out.write("              <li class=\"pull-right\">\r\n");
      out.write("                <ul class=\"top-menu\">\r\n");
      out.write("                \t<li class=\"logo\" style=\"position: relative; top: 1px;\">\r\n");
      out.write("                    \t<a class=\"my\" href=\"/goMain\">\r\n");
      out.write("                    \t<i class=\"md-timer-auto\" style=\"width: 200%; height: 200%;\"> Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ Username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("  ( ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ Useremail }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" ) </i></a>\r\n");
      out.write("                \t</li> \r\n");
      out.write("                    <li class=\"dropdown\">\r\n");
      out.write("                        <a data-toggle=\"dropdown\" class=\"tm-settings\" href=\"\"></a>\r\n");
      out.write("                        <ul class=\"dropdown-menu dm-icon pull-right\">\r\n");
      out.write("                       \t\t<li>\r\n");
      out.write("                            \t<a href=\"/doLogout\"><i class=\"md md-history\"></i> Logout</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a data-action=\"fullscreen\" href=\"\"><i class=\"md md-fullscreen\"></i> Toggle Fullscreen</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"/doAboutProfile\"><i class=\"md md-person\"></i> Privacy Settings</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            \r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </header>\r\n");
      out.write("        \r\n");
      out.write("        <section id=\"main\">\r\n");
      out.write("\t        <div id=\"left_menu\">\r\n");
      out.write("\t\t\t\t<div id=\"profile\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/view/profile.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"team_menu\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/team/team_menu.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"mine\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/member/mine.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"main_menu\">\r\n");
      out.write("\t\t\t\t<div id=\"defaultPage\">\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t<ul class=\"tab-nav tn-justified\">\r\n");
      out.write("\t\t\t\t\t    <li class=\"waves-effect\"><a href=\"/teamInfo\">Team Information</a></li>\r\n");
      out.write("\t\t\t\t\t    <li class=\"waves-effect\"><a href=\"/chatCalendar\">Chat By Calendar</a></li>\r\n");
      out.write("\t\t\t\t\t    <li class=\"active waves-effect\"><a href=\"/chatMember\">Chat By Member</a></li>\r\n");
      out.write("\t\t\t\t\t    <li class=\"waves-effect\"><a href=\"/propertyMember\">Property By Member</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<div class=\"tab-content\">\r\n");
      out.write("\t\t\t\t\t    <div role=\"tabpanel\" class=\"tab-pane active\" id=\"home11\">\r\n");
      out.write("\t\t\t\t\t          <div class=\"block-header\">\r\n");
      out.write("\t\t\t\t\t              <h2>Buttons</h2>\r\n");
      out.write("\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t              <ul class=\"actions\">\r\n");
      out.write("\t\t\t\t\t                  <li>\r\n");
      out.write("\t\t\t\t\t                      <a href=\"\">\r\n");
      out.write("\t\t\t\t\t                          <i class=\"md md-trending-up\"></i>\r\n");
      out.write("\t\t\t\t\t                      </a>\r\n");
      out.write("\t\t\t\t\t                  </li>\r\n");
      out.write("\t\t\t\t\t                  <li>\r\n");
      out.write("\t\t\t\t\t                      <a href=\"\">\r\n");
      out.write("\t\t\t\t\t                          <i class=\"md md-done-all\"></i>\r\n");
      out.write("\t\t\t\t\t                      </a>\r\n");
      out.write("\t\t\t\t\t                  </li>\r\n");
      out.write("\t\t\t\t\t                  <li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t                      <a href=\"\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t                          <i class=\"md md-more-vert\"></i>\r\n");
      out.write("\t\t\t\t\t                      </a>\r\n");
      out.write("\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t                      <ul class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("\t\t\t\t\t                          <li>\r\n");
      out.write("\t\t\t\t\t                              <a href=\"\">Refresh</a>\r\n");
      out.write("\t\t\t\t\t                          </li>\r\n");
      out.write("\t\t\t\t\t                          <li>\r\n");
      out.write("\t\t\t\t\t                              <a href=\"\">Manage Widgets</a>\r\n");
      out.write("\t\t\t\t\t                          </li>\r\n");
      out.write("\t\t\t\t\t                          <li>\r\n");
      out.write("\t\t\t\t\t                              <a href=\"\">Widgets Settings</a>\r\n");
      out.write("\t\t\t\t\t                          </li>\r\n");
      out.write("\t\t\t\t\t                      </ul>\r\n");
      out.write("\t\t\t\t\t                  </li>\r\n");
      out.write("\t\t\t\t\t              </ul>\r\n");
      out.write("\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t          <div class=\"card\">\r\n");
      out.write("\t\t\t\t\t              <div class=\"card-header\">\r\n");
      out.write("\t\t\t\t\t                  <h2>Basic Examples <small>Use any of the available button classes to quickly create a styled button.</small></h2>\r\n");
      out.write("\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t                  <ul class=\"actions\">\r\n");
      out.write("\t\t\t\t\t                      <li class=\"dropdown action-show\">\r\n");
      out.write("\t\t\t\t\t                          <a href=\"\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t                              <i class=\"md md-more-vert\"></i>\r\n");
      out.write("\t\t\t\t\t                          </a>\r\n");
      out.write("\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t                          <div class=\"dropdown-menu pull-right\">\r\n");
      out.write("\t\t\t\t\t                              <p class=\"p-20\">\r\n");
      out.write("\t\t\t\t\t                                  You can put anything here\r\n");
      out.write("\t\t\t\t\t                              </p>\r\n");
      out.write("\t\t\t\t\t                          </div>\r\n");
      out.write("\t\t\t\t\t                      </li>\r\n");
      out.write("\t\t\t\t\t                  </ul>\r\n");
      out.write("\t\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t              <div class=\"card-body card-padding\">\r\n");
      out.write("\t\t\t\t\t                  <p class=\"f-500 c-black m-b-20\">Bootstrap Color Schemes</p>\r\n");
      out.write("\t\t\t\t\t                  \r\n");
      out.write("\t\t\t\t\t                  <div class=\"btn-demo\">\r\n");
      out.write("\t\t\t\t\t                      <button class=\"btn btn-default\">Default</button>\r\n");
      out.write("\t\t\t\t\t                      <button class=\"btn btn-info\">Info</button>\r\n");
      out.write("\t\t\t\t\t                      <button class=\"btn btn-primary\">Primary</button>\r\n");
      out.write("\t\t\t\t\t                      <button class=\"btn btn-success\">Success</button>\r\n");
      out.write("\t\t\t\t\t                      <button class=\"btn btn-warning\">Warning</button>\r\n");
      out.write("\t\t\t\t\t                      <button class=\"btn btn-danger\">Danger</button>\r\n");
      out.write("\t\t\t\t\t                  </div>\r\n");
      out.write("\t\t\t\t\t                  \r\n");
      out.write("\t\t\t\t\t                  <br/>\r\n");
      out.write("\t\t\t\t\t                  <br/>\r\n");
      out.write("\t\t\t\t\t                  \r\n");
      out.write("\t\t\t\t\t                  <p class=\"f-500 c-black m-b-20\">Optional Material Design Colors</p>\r\n");
      out.write("\t\t\t\t\t                  \r\n");
      out.write("\t\t\t\t\t                  <div class=\"btn-colors btn-demo\"> Optional container for demo porpose only\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-cyan\">Cyan</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-teal\">Teal</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-amber\">Amber</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-orange\">Orange</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-deeporange\">Deep Orange</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-red\">Red</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-pink\">Pink</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-lightblue\">Light Blue</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-blue\">Blue</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-indigo\">Indigo</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-lime\">Lime</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-lightgreen\">Light Green</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-green\">Green</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-purple\">Purple</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-deeppurple\">Deep Purple</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-gray\">Gray</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-bluegray\">Blue Gray</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn bgm-black\">Black</button>\r\n");
      out.write("\t\t\t\t\t                      </div>\r\n");
      out.write("\t\t\t\t\t                      \r\n");
      out.write("\t\t\t\t\t                      <br/>\r\n");
      out.write("\t\t\t\t\t                      <br/>\r\n");
      out.write("\t\t\t\t\t                      \r\n");
      out.write("\t\t\t\t\t                      <p class=\"f-500 c-black m-b-5\">Button Sizes</p>\r\n");
      out.write("\t\t\t\t\t                      <small>Fancy larger or smaller buttons? Add the button sizing classes.</small>\r\n");
      out.write("\t\t\t\t\t                      \r\n");
      out.write("\t\t\t\t\t                      <br/>\r\n");
      out.write("\t\t\t\t\t                      <br/>\r\n");
      out.write("\t\t\t\t\t                      \r\n");
      out.write("\t\t\t\t\t                      <div class=\"btn-demo\">\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-primary btn-lg\">Large</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-primary\">Default</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-primary btn-sm\">Small</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-primary btn-xs\">Extra Small</button>\r\n");
      out.write("\t\t\t\t\t                      </div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t                      <br/>\r\n");
      out.write("\t\t\t\t\t                      <br/>\r\n");
      out.write("\t\t\t\t\t                      \r\n");
      out.write("\t\t\t\t\t                      <p class=\"f-500 c-black m-b-20\">Disable Stat</p>\r\n");
      out.write("\t\t\t\t\t                      \r\n");
      out.write("\t\t\t\t\t                      <div class=\"btn-demo\">\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-default\" disabled=\"disabled\">Default</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-info\" disabled=\"disabled\">Info</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-primary\" disabled=\"disabled\">Primary</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-success\" disabled=\"disabled\">Success</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-warning\" disabled=\"disabled\">Warning</button>\r\n");
      out.write("\t\t\t\t\t                          <button class=\"btn btn-danger\" disabled=\"disabled\">Danger</button>\r\n");
      out.write("\t\t\t\t\t                      </div>\r\n");
      out.write("\t\t\t\t\t                  </div>\r\n");
      out.write("\t\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t      \t\t</div>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"right_menu\">\r\n");
      out.write("\t\t\t\t<div id=\"calendar\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/calendar/calendar.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"chatbyMem\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/chat/chat_mem.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"chatbyKeyword\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/view/chat/chat_keyword.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t    <div class=\"clear\"></div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/view/tab/chatByMember.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("root");
    // /WEB-INF/view/tab/chatByMember.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /WEB-INF/view/tab/chatByMember.jsp(100,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("Username");
    // /WEB-INF/view/tab/chatByMember.jsp(100,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope._MEMBER_.name }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    // /WEB-INF/view/tab/chatByMember.jsp(101,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("Useremail");
    // /WEB-INF/view/tab/chatByMember.jsp(101,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope._MEMBER_.email }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent(null);
    // /WEB-INF/view/tab/chatByMember.jsp(102,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("root");
    // /WEB-INF/view/tab/chatByMember.jsp(102,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }
}