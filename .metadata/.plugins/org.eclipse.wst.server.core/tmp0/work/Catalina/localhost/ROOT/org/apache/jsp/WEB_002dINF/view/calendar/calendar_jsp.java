/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-28 05:05:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.calendar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calendar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1459141369161L));
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

      out.write(" \r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>      \r\n");
      out.write("        <section id=\"main\">\r\n");
      out.write("           \r\n");
      out.write("        </section>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Javascript Libraries -->\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/nicescroll/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/fullcalendar/lib/moment.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/fullcalendar/fullcalendar.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/waves/waves.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/bootstrap-growl/bootstrap-growl.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/vendors/sweet-alert/sweet-alert.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/js/functions.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resource/js/demo.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("                var date = new Date();\r\n");
      out.write("                var d = date.getDate();\r\n");
      out.write("                var m = date.getMonth();\r\n");
      out.write("                var y = date.getFullYear();\r\n");
      out.write("\r\n");
      out.write("                var cId = $('#calendar'); //Change the name if you want. I'm also using thsi add button for more actions\r\n");
      out.write("\r\n");
      out.write("                //Generate the Calendar\r\n");
      out.write("                cId.fullCalendar({\r\n");
      out.write("                    header: {\r\n");
      out.write("                        right: '',\r\n");
      out.write("                        center: 'prev, title, next',\r\n");
      out.write("                        left: ''\r\n");
      out.write("                    },\r\n");
      out.write("\r\n");
      out.write("                    theme: true, //Do not remove this as it ruin the design\r\n");
      out.write("                    selectable: true,\r\n");
      out.write("                    selectHelper: true,\r\n");
      out.write("                    editable: true,\r\n");
      out.write("\r\n");
      out.write("                    //Add Events\r\n");
      out.write("                    events: [\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Hangout with friends',\r\n");
      out.write("                            start: new Date(y, m, 1),\r\n");
      out.write("                            end: new Date(y, m, 2),\r\n");
      out.write("                            className: 'bgm-cyan'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Meeting with client',\r\n");
      out.write("                            start: new Date(y, m, 10),\r\n");
      out.write("                            allDay: true,\r\n");
      out.write("                            className: 'bgm-red'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Repeat Event',\r\n");
      out.write("                            start: new Date(y, m, 18),\r\n");
      out.write("                            allDay: true,\r\n");
      out.write("                            className: 'bgm-blue'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Semester Exam',\r\n");
      out.write("                            start: new Date(y, m, 20),\r\n");
      out.write("                            end: new Date(y, m, 23),\r\n");
      out.write("                            className: 'bgm-green'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Soccor match',\r\n");
      out.write("                            start: new Date(y, m, 5),\r\n");
      out.write("                            end: new Date(y, m, 6),\r\n");
      out.write("                            className: 'bgm-purple'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Coffee time',\r\n");
      out.write("                            start: new Date(y, m, 21),\r\n");
      out.write("                            className: 'bgm-orange'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Job Interview',\r\n");
      out.write("                            start: new Date(y, m, 5),\r\n");
      out.write("                            className: 'bgm-dark'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'IT Meeting',\r\n");
      out.write("                            start: new Date(y, m, 5),\r\n");
      out.write("                            className: 'bgm-cyan'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Brunch at Beach',\r\n");
      out.write("                            start: new Date(y, m, 1),\r\n");
      out.write("                            className: 'bgm-purple'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Live TV Show',\r\n");
      out.write("                            start: new Date(y, m, 15),\r\n");
      out.write("                            end: new Date(y, m, 17),\r\n");
      out.write("                            className: 'bgm-orange'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Software Conference',\r\n");
      out.write("                            start: new Date(y, m, 25),\r\n");
      out.write("                            end: new Date(y, m, 28),\r\n");
      out.write("                            className: 'bgm-blue'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Coffee time',\r\n");
      out.write("                            start: new Date(y, m, 30),\r\n");
      out.write("                            className: 'bgm-orange'\r\n");
      out.write("                        },\r\n");
      out.write("                        {\r\n");
      out.write("                            title: 'Job Interview',\r\n");
      out.write("                            start: new Date(y, m, 30),\r\n");
      out.write("                            className: 'bgm-dark'\r\n");
      out.write("                        },\r\n");
      out.write("                    ],\r\n");
      out.write("                     \r\n");
      out.write("                    //On Day Select\r\n");
      out.write("                    select: function(start, end, allDay) {\r\n");
      out.write("                        $('#addNew-event').modal('show');   \r\n");
      out.write("                        $('#addNew-event input:text').val('');\r\n");
      out.write("                        $('#getStart').val(start);\r\n");
      out.write("                        $('#getEnd').val(end);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                //Create and ddd Action button with dropdown in Calendar header. \r\n");
      out.write("                var actionMenu = '<ul class=\"actions actions-alt\" id=\"fc-actions\">' +\r\n");
      out.write("                                    '<li class=\"dropdown\">' +\r\n");
      out.write("                                        '<a href=\"\" data-toggle=\"dropdown\"><i class=\"md md-more-vert\"></i></a>' +\r\n");
      out.write("                                        '<ul class=\"dropdown-menu dropdown-menu-right\">' +\r\n");
      out.write("                                            '<li class=\"active\">' +\r\n");
      out.write("                                                '<a data-view=\"month\" href=\"\">Month View</a>' +\r\n");
      out.write("                                            '</li>' +\r\n");
      out.write("                                            '<li>' +\r\n");
      out.write("                                                '<a data-view=\"basicWeek\" href=\"\">Week View</a>' +\r\n");
      out.write("                                            '</li>' +\r\n");
      out.write("                                            '<li>' +\r\n");
      out.write("                                                '<a data-view=\"agendaWeek\" href=\"\">Agenda Week View</a>' +\r\n");
      out.write("                                            '</li>' +\r\n");
      out.write("                                            '<li>' +\r\n");
      out.write("                                                '<a data-view=\"basicDay\" href=\"\">Day View</a>' +\r\n");
      out.write("                                            '</li>' +\r\n");
      out.write("                                            '<li>' +\r\n");
      out.write("                                                '<a data-view=\"agendaDay\" href=\"\">Agenda Day View</a>' +\r\n");
      out.write("                                            '</li>' +\r\n");
      out.write("                                        '</ul>' +\r\n");
      out.write("                                    '</div>' +\r\n");
      out.write("                                '</li>';\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                cId.find('.fc-toolbar').append(actionMenu);\r\n");
      out.write("                \r\n");
      out.write("                //Event Tag Selector\r\n");
      out.write("                (function(){\r\n");
      out.write("                    $('body').on('click', '.event-tag > span', function(){\r\n");
      out.write("                        $('.event-tag > span').removeClass('selected');\r\n");
      out.write("                        $(this).addClass('selected');\r\n");
      out.write("                    });\r\n");
      out.write("                })();\r\n");
      out.write("            \r\n");
      out.write("                //Add new Event\r\n");
      out.write("                $('body').on('click', '#addEvent', function(){\r\n");
      out.write("                    var eventName = $('#eventName').val();\r\n");
      out.write("                    var tagColor = $('.event-tag > span.selected').attr('data-tag');\r\n");
      out.write("                        \r\n");
      out.write("                    if (eventName != '') {\r\n");
      out.write("                        //Render Event\r\n");
      out.write("                        $('#calendar').fullCalendar('renderEvent',{\r\n");
      out.write("                            title: eventName,\r\n");
      out.write("                            start: $('#getStart').val(),\r\n");
      out.write("                            end:  $('#getEnd').val(),\r\n");
      out.write("                            allDay: true,\r\n");
      out.write("                            className: tagColor\r\n");
      out.write("                            \r\n");
      out.write("                        },true ); //Stick the event\r\n");
      out.write("                        \r\n");
      out.write("                        $('#addNew-event form')[0].reset()\r\n");
      out.write("                        $('#addNew-event').modal('hide');\r\n");
      out.write("                    }\r\n");
      out.write("                    \r\n");
      out.write("                    else {\r\n");
      out.write("                        $('#eventName').closest('.form-group').addClass('has-error');\r\n");
      out.write("                    }\r\n");
      out.write("                });   \r\n");
      out.write("\r\n");
      out.write("                //Calendar views\r\n");
      out.write("                $('body').on('click', '#fc-actions [data-view]', function(e){\r\n");
      out.write("                    e.preventDefault();\r\n");
      out.write("                    var dataView = $(this).attr('data-view');\r\n");
      out.write("                    \r\n");
      out.write("                    $('#fc-actions li').removeClass('active');\r\n");
      out.write("                    $(this).parent().addClass('active');\r\n");
      out.write("                    cId.fullCalendar('changeView', dataView);  \r\n");
      out.write("                });\r\n");
      out.write("            });                        \r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
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
    // /WEB-INF/view/calendar/calendar.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("root");
    // /WEB-INF/view/calendar/calendar.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
