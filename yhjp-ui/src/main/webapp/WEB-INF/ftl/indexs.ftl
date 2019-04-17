<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <title>The Flying Saucer Project</title>
  <script src="/static/js/jquery-3.3.1.min.js"></script>
</head>
<style>
@page{size : 420mm 297mm;}

#fs h1, #fs h2 {
  border-style: none none solid;
  border-color: rgb( 0, 0, 0 );
  border-width: 0px;
  background: rgb( 255, 255, 255 ) none repeat scroll left top;
  margin-top: 30px;
  padding-bottom: 3px;
  font-family: Verdana, Arial, Helvetica, sans-serif;
  font-weight: normal;
  padding-top: 15px;
  word-spacing: normal;
  letter-spacing: normal;
}

#fs h2, #fs h3 {
  color: black;
  background-color: white;
}

#fs h2 {
  text-decoration: underline;
}

.fs_heading {
  clear: both;
  background-color: white;
}

body, #fs {
  background: rgb( 255, 255, 255 ) none repeat scroll 0% 50%;
  margin-right: 4px;
  margin-left: 20px;
  font-family: Verdana, Arial, Helvetica, sans-serif;
}

/* the menu box itself */
#menu {
  padding: 0px 0px;
  float: right;
  border: 0px solid blue;
  font-size: 90%;
  margin: 0px;
  margin-left: 5px;
}

/*
        #menu ul is the sub menu
        #menu ul li is the sub menu items
    */

/* the top menu of each section */
#menu li {
  list-style-type: none;
  border: 0px solid blue;
  background-color: #BFE4FF;
  color: #6096BF;
  margin-top: 10px;
  padding-top: 5px;
}

#menu li b {
  border: 0px solid red;
  padding-left: 10px;
}

/* the box around each section */
#menu ul, #menu h4 {
  margin-top: 3px;
  border: 0px solid red;
  background-color: #E6F4FF;
}

/* the items in each section */
#menu ul li {
  border: 0px solid gray;
  text-align: right;
  padding: 1px 2px;
  margin: 0px;
  padding-right: 6px;
  background-color: #E6F4FF;
}

#menu ul li a {
  border: 0px dashed blue;
  color: black;
  text-decoration: none;
}

#menu ul li a:hover {
  text-decoration: underline;
}

#menu ul li a:hover {
  text-decoration: underline;
}

code {
  font-weight: bold;
  color: rgb( 153, 153, 0 );
}

pre {
  border: 1px dotted rgb( 255, 204, 0 );
  margin: 10px;
  padding: 6px;
  background: rgb( 255, 255, 204 ) none repeat scroll 0% 50%;
}

.invalid {
  text-decoration: line-through;
}

hr.news {
  width: 30%;
  border: 1px solid black;
  margin-top: 20px;
  margin-bottom: 40px;
}

.downloadbox {
  width: 150px;
  font-weight: bold;
  font-size: 8pt;
  border: 1px solid blue;
  margin: 0px 10px 15px 0px;
  float: left;
  padding: 10px 5px 10px 5px;
  text-align: center;
}


#logo { float: left;
}
.clearit { clear: both;
}
h2 { width: 500px;
}
ul#m2 { border: 1px solid black;
  float: right;
}
block { border: 0px solid black;
  display: block;
  padding-left: 4em;
}
.axial { border: 1px solid black; display: none;}
p.screenshot { text-align: center; }
p.screenshot img { border-width: 0px; }
div.thumbnailx {
  float: left;
  width: 140px;
  min-height: 120px;
  border: 1px solid #999;
  margin: 0 15px 15px 0;
  padding: 10px 15px 10px 15px;
}

.clearboth { clear: both; }

div.thumbnail {
  float: left;
  width: 140px;
  padding: 10px;
  border: 1px solid #999;
  margin: 0 10px 15px 0;
  min-height: 120px;
}

div.thumbnail p {
  text-align: center;
}

div.thumbnail img {
  border: none;
}

a#fs_logo {
  background: url('/images/new_saucer.png') no-repeat top left transparent;
  float: left;
  width: 180px;
  height: 180px;
  display: block;
}

a#fs_logo:hover {
  background: url('/images/acid2.png') no-repeat center center transparent;
}

table.properties  {
  border-collapse: collapse;
}
table.properties td {
  border: 1px solid black;
  vertical-align: top;
}
</style>
<body style="height:3508px;width: 4961px">

<div id="fs">

  <div id="menu">

    <ul>
      <li><input type="button" onclick="getAllHtml()" value="??"></li>
      <li>Downloads
        <ul>
          <li><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/downloads/flyingsaucer-R8.zip">Release 8 Binaries</a></li>
          <li><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/downloads/flyingsaucer-R8-src.zip">Release 8 All Files</a></li>
        </ul>
      </li>
      <li>About Flying Saucer
        <ul>
          <li><a href="/index.html">Project Home</a></li>
          <li><a href="/news.html">News</a></li>
          <li><a href="/feature-list.html">Feature List</a></li>
          <li><a href="/faq.html">The <span class="caps">FAQ</span></a></li>
          <li><a href="/screenshots.html">Screenshots</a></li>
          <li><a href="/demos.html">Demos</a></li>
          <li><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/doc/guide/users-guide-R8.html">User's Guide R8 &#8211; <span class="caps">HTML</span></a></li>
          <li><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/doc/guide/users-guide-R8.pdf">User's Guide R8 &#8211; <span class="caps">PDF</span></a></li>
          <li><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/javadoc/user/index.html">Javadoc &#8211; Basic</a></li>
          <li><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/javadoc/full/index.html">Javadoc &#8211; Full</a></li>
          <li><a href="/references.html">References</a></li>
          <li><a href="http://www.gnu.org/copyleft/lesser.html" title="LGPL">License</a></li>
        </ul>
      </li>
      <li>Contribute
        <ul>
          <li><a href="https://xhtmlrenderer.dev.java.net/servlets/ProjectMailingListList">Mail: User's List</a></li>
          <li><a href="https://xhtmlrenderer.dev.java.net/servlets/ProjectMailingListList">Mail: Dev List</a></li>
        </ul>
      </li>
    </ul>


  </div>

  <h1>The Flying Saucer Project</h1>

  <p><a id="fs_logo" href="faq.html#acid2">&nbsp;</a></p>

  <h3 class="fs_heading" style=" clear: none ;">An <span class="caps">XML</span>/XHTML/CSS 2.1 Renderer</h3>

  <p><em>(in 100% Java)</em></p>

  <h2 class="fs_heading" style=" clear: both ;">Download Now!</h2>

  <table class="properties" style="width: 100% ;">
    <tbody>
    <tr>
      <td><strong>Status</strong></td>
      <td><strong>Type</strong></td>
      <td><strong>URL</strong></td>
      <td><strong>Description</strong></td>
      <td><strong>MD5 Sum</strong></td>
    </tr>
    <tr>
      <td><strong>STABLE</strong></td>
      <td>Binary Zip</td>
      <td><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/downloads/flyingsaucer-R8.zip">flyingsaucer-R8.zip</a></td>
      <td>For using Flying Saucer in your own programs (3.0M)</td>
      <td><a href="sig/flyingsaucer-R8.zip.md5.txt">MD5 Checksum</a> <a href="sig/flyingsaucer-R8.zip.asc.txt">SHA Checksum</a></td>
    </tr>
    <tr>
      <td><strong>STABLE</strong></td>
      <td>Source Bundle Zip</td>
      <td><a href="http://pigeonholdings.com/projects/flyingsaucer/R8/downloads/flyingsaucer-R8-src.zip">flyingsaucer-R8-src.zip</a></td>
      <td>Includes source, demo programs, sample code, etc.  (7.5M)</td>
      <td><a href="sig/flyingsaucer-R8-src.zip.md5.txt">MD5 Checksum</a> <a href="sig/flyingsaucer-R8-src.zip.asc.txt">SHA Checksum</a></td>
    </tr>
    </tbody>
  </table>

  <p>If you'd like to access <em>everything</em>, please use our source code repository (CVS); see the link to <span class="caps">CVS</span> on the left side of this page.</p>

  <h2 class="fs_heading" style=" clear: left ;">Quick News</h2>

  <p style="font-size: 14pt;">Release 7 No Longer Available</p>

  <p><strong>July 1, 2009</strong>: The release files for Release 7 (R7) are no longer available. While we recommend that you work with the current R8 release, if for some reason you need to stick with the R7 release you can check out that version of the source code from our <span class="caps">CVS</span> repository. The R7 release is tagged in the repository as R7_FINAL.</p>

  <p style="font-size: 14pt;">Release 8 &#8211; Final (R8)</p>

  <p><strong>April 18, 2009</strong>: We are proud to present our R8 release. This release includes no changes since R8 release candidate 2.</p>

  <p>Our R8 release includes a number of improvements over R7, as well as bug fixes. You can read the complete list of changes on our <a href="./news.html">news</a> page; here are some<br />
    highlights about what you'll find in R8:</p>

  <ul>
    <li><span class="caps">PDF</span>
      <ul>
        <li>Upgrade to use iText 2.0.8</li>
        <li>Support adding custom header properties on <span class="caps">PDF</span> output</li>
        <li>Add ability to set <span class="caps">PDF</span> version programmatically</li>
        <li>Add ability to manipulate <span class="caps">PDF</span> output document before it's closed</li>
        <li>Add ability to have different starting page number for first document in multiple documents</li>
        <li>Add <span class="caps">API</span> to retrieve <span class="caps">PDF</span> page and coordinates for boxes with an ID attribute</li>
        <li>Implement <span class="caps">CMYK</span> color support for <span class="caps">PDF</span> output</li>
        <li>Support encryption of <span class="caps">PDF</span> output</li>
      </ul>
    </li>
    <li>Swing
      <ul>
        <li>Basic support for selection, highlighting and copying</li>
      </ul>
    </li>
    <li>General
      <ul>
        <li>Expose copy of parsed entities from catalog.</li>
        <li>Preliminary support for data URLs</li>
        <li>Support True Type Collection (.ttc) files</li>
        <li>Preliminary support for Type 1 fonts</li>
        <li>Support logging via Log4J as an alternative to <span class="caps">JDK</span> logging (requires recompile)</li>
        <li>Handle hidden form elements</li>
        <li>Rudimentary support for JavaScript links (from Dan Kaplan)</li>
        <li>Support for callback on form submission</li>
      </ul>
    </li>
    <li><span class="caps">CSS</span>
      <ul>
        <li>Prelimary support for @font-face rules</li>
        <li>Implement partial support for leader and target-counter (patch from Karl Tauber)</li>
        <li>Table pagination.  When turned on (by setting the <code>-fs-table-pagination</code> property to <code>paginate</code> vs. a default of <code>auto</code> ), tables and table cells will be closed (with appropriate borders and padding) when a page ends and reopened when a page starts. Additionally, a table's <code>thead</code> and <code>tfoot</code> will be repeated on each page.</li>
        <li><a href="http://www.w3.org/TR/css3-page/#margin-boxes">CSS3 margin boxes</a></li>
        <li><a href="http://www.w3.org/TR/css3-page/#using-named-pages">Named pages</a></li>
        <li><a href="http://www.w3.org/TR/2007/WD-css3-gcpm-20070504/#running1">Running elements</a></li>
        <li><a href="http://www.w3.org/TR/css3-selectors/#attrnmsp">Namespace-aware <span class="caps">CSS</span> matching</a>, for example, with attributes [although this also applies to elements]</li>
        <li><a href="http://www.w3.org/TR/css3-selectors/#pseudo-elements">Pseudo-elements</a> may now be specified with a double colon</li>
        <li><a href="http://www.w3.org/TR/css3-selectors/#attribute-substrings">Substring selectors</a></li>
        <li>The background property can now be used in a @page context &#8211; <a href="http://www.w3.org/TR/css3-page/#page-properties">CSS 3 spec</a></li>
        <li>Custom property to limit the scope of the page and pages counters to a portion of the document</li>
        <li>Custom property that instructs FS to try to avoid breaking a box so that only borders and padding appear on a page</li>
      </ul>
    </li>
  </ul>


  <p><a href="./news.html">More news...</a></p>

  <h2 class="fs_heading" style=" clear: left ;">Project Statistics</h2>

  <p>Thanks to the <a href="http://www.ohloh.net/p/xhtmlrenderer">Ohloh website</a>.</p>

  <p><script type="text/javascript" src="http://www.ohloh.net/p/659/widgets/project_basic_stats.js"></script></p>

  <h2 class="fs_heading" style=" clear: left ;">New Around Here?</h2>

  <p>If you're new to the project, you may want to read two <strong>great</strong> articles about using Flying Saucer for practical purposes:</p>

  <ul>
    <li><a href="http://today.java.net/pub/a/today/2007/06/26/generating-pdfs-with-flying-saucer-and-itext.html">Generating PDFs for Fun and Profit with Flying Saucer and iText</a>, by Josh Marinacci from June 2007.  Josh covers using Flying Saucer to generate <span class="caps">PDF</span> documents; the article is available on <a href="http://java.net">http://java.net</a>.</li>
    <li><a href="http://today.java.net/pub/a/today/2006/10/31/combine-facelets-and-flying-saucer-renderer.html">Combine <span class="caps">JSF</span> Facelets and the Flying Saucer <span class="caps">XHTML</span> Renderer</a> by Jacobus Steenkamp from October 2006. Jacobus covers using Flying Saucer to generate <span class="caps">PDF</span>, image and <span class="caps">SVG</span> output, with a focus on on-the-fly generation. The article is on <a href="http://java.net">http://java.net</a>.</li>
  </ul>


  <p>There's also a blog entry by Dieter Wimberger <a href="http://wimpi.coalevo.net/2007/05/customizable-im-frontend-with-xhtmlcss.html">Customizable IM frontend with <span class="caps">XHTML</span>+CSS rendering using Flying Saucer</a></p>

  <h2 class="fs_heading">Demos</h2>

  <p>Check out our spiffy <a href="demos.html">demo apps</a>.</p>

  <h2 class="fs_heading">Helping Out</h2>

  <p>We need help!</p>

  <p>If you want to contribute or just see what's going on then please join the dev <a href="https://xhtmlrenderer.dev.java.net/servlets/ProjectMailingListList">mailing list</a>! We need developers, beta testers, doc writers, evangelists, and users.</p>

  <p>Keep up with new releases: <a href="http://xhtmlrenderer.dev.java.net/servlets/ProjectNewsRSS"><img src="https://java-net.dev.java.net/branding/images/xml.gif" /></a></p>

  <h2 class="fs_heading">Special thanks to</h2>

  <p><img src="./images/xiLogo64.png" style="float: left; margin-right: 10px;" /></p>

  <p>This project website and our User's Guide are produced using the <a href="http://xilize.sourceforge.net/">Xilize</a> (http://xilize.sourceforge.net/) syntax and rendering engine. The content is written in Xilize text markup, then converted to <span class="caps">XHTML</span> using the Xilize converter. We'd like to thank the Xilize team at CenteredWork for sharing this library. Try it out! It's a great way to write websites quickly, without losing control over formatting. Check it out!</p>

  <p><img src="./images/made-with-jedit-9.png" style="float: left; margin-right: 10px;" /></p>

  <p>Editing took place using the legendary <a href="http://www.jedit.org/">jEdit editor</a> (http://www.jedit.org/) editor. Xilize produces a plugin for jEdit, where you get syntax highlighting for the Xilize markup, quick markup controls, and a <span class="caps">XIL</span> converter all built-in to the editor.</p>

  <p><a href="http://www.jetbrains.com">JetBrains</a>, the makers of <a href="http://www.jetbrains.com/idea">IntelliJ <span class="caps">IDEA</span></a>, has generously sponsored a license letting us use <span class="caps">IDEA</span> on this project under their Open Source Program. We are grateful for their support!</p>

  <p style="clear:both;">Links:</p>

  <ul>
    <li><a href="http://xilize.sourceforge.net/">Xilize</a> http://xilize.sourceforge.net/</li>
    <li><a href="http://www.jedit.org">jEdit</a> http://www.jedit.org</li>
  </ul>


</div>
</body>
<script>
  function getAllHtml() {
    var html = document.getElementsByTagName('html')[0].innerHTML;
    $.ajax({
      url: "http://localhost:8082/test/savePdfV2/",
      type: "POST",
      contentType: "application/json;charset=utf-8",
      data: html,
      dataType: "text",
      success: function (result) {
        if (result == "success") {
          obj.parents('form').submit();
        } else {
        }
      },
      error: function (msg) {
        $(".notice").html('Error:' + msg);
      }
    })
    return false;
  }
</script>
</html>


