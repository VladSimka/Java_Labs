<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:attribute-set name="tableBorder">
        <xsl:attribute name="border">solid 0.1 mm black</xsl:attribute>
    </xsl:attribute-set>

    <xsl:template match="banks">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4"
                                       page-height="29.7cm" page-width="21.0cm" margin="1cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">

                <fo:flow flow-name = "xsl-region-body">

                    <fo:block font-size="16pt" font-family="Times New Roman"  space-after="5mm">
                        <xsl:value-of select="bankname"/>
                    </fo:block>

                    <fo:block font-size="10pt">
                        <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-header>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Id</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Country</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Type</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Depositor</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Amount On Deposit</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Profitability</fo:block>
                                </fo:table-cell>
                                <fo:table-cell xsl:use-attribute-sets="tableBorder">
                                    <fo:block font-weight="bold">Time Constraints</fo:block>
                                </fo:table-cell>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:apply-templates select="bank"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                </fo:flow>

            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="bank">
        <fo:table-row>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="accountId"/>
                </fo:block>
            </fo:table-cell>

            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="name"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="country"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="type"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="depositor"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="amountOnDeposit"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="profitability"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell xsl:use-attribute-sets="tableBorder">
                <fo:block>
                    <xsl:value-of select="timeConstraints"/>
                </fo:block>
            </fo:table-cell>

        </fo:table-row>
    </xsl:template>

</xsl:stylesheet>