<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.OutputStreamWriter" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.nio.charset.StandardCharsets" %>

<%
    String numeroPagina = request.getParameter("numero");
    String dataDir = request.getParameter("dataDir");
    String url = request.getParameter("url_data") + numeroPagina;

    String xmlOut ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\n";
    xmlOut += "<cars>\n" +
                    "  <medata>\n";
    xmlOut += "    <url>" +
        url +
        "</url>\n";
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    xmlOut+= "    <date>" +
            formatoFecha.format(new Date()) +
            "</date>\n";
    xmlOut += "    <user>daw</user>\n" +
            "  </medata>\n";
    xmlOut += "  <listCars>\n";

    Document web = Jsoup.connect(url).get();
    Elements elementos = web.select("div.main-page > ul > li.js-relocation-destination");
    boolean primero = true;
    for (Element elemento: elementos) {
//        xmlOut += elemento.html();
        String nombre = elemento.select("a:eq(0) > h2").text();
        String urlImage = "";
        if (primero) {
            urlImage = elemento.select("a:eq(1) > img").attr("src");
            primero = false;
        } else {
            urlImage = elemento.select("a:eq(1) > img").attr("data-original");
        }
        String texto = elemento.select("p.summary").text();
        String fechaPub = elemento.select("p.publish-date").text();
        xmlOut += "    <car name='" +
                nombre +
                "'>\n";
        xmlOut += "      <urlImage>" +
                urlImage +
                "</urlImage>\n";
        xmlOut += "      <text>" +
                "<![CDATA[" + texto + "]]>" +
                "</text>\n";
        xmlOut += "      <publishDate>" +
                fechaPub +
                "</publishDate>\n";
        xmlOut += "    </car>\n";
    }
    xmlOut += "  </listCars>\n";
    xmlOut += "</cars>\n";

    OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dataDir + numeroPagina + ".xml"), StandardCharsets.UTF_8);
    writer.write(xmlOut);
    writer.close();
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(xmlOut);
%>
