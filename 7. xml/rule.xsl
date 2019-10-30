<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xml:template match="/">
<html>
<body>
    <xsl:for-each select="books/book">
    <span style="font-weight:bold"><xsl:value-of select="title"/></span>
    <span style="font-family:Arial"><xsl:value-of select="author"/></span>
    </xsl:value-of>
</body>
</html>
</xml:template>
</xsl:stylesheet>