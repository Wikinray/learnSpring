<?xml version="1.0" encoding="UTF-8"?>
<template>

    <comment ID="addJavaFileComment"></comment>


    <comment ID="addComment"><![CDATA[

        ]]>
    </comment>


    <comment ID="addRootComment"></comment>


    <comment ID="addFieldComment"><![CDATA[
<#if introspectedColumn??>
/**
<#if introspectedColumn.remarks?? && introspectedColumn.remarks != ''>
<#list introspectedColumn.remarks?split("\n") as remark>
* ${remark}
</#list>
</#if>
* ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
*/
<#else>
/**
* ${introspectedTable.fullyQualifiedTable}
*/
</#if>
        ]]>
    </comment>

    <comment ID="addModelClassComment"><![CDATA[
/**
<#if introspectedTable.remarks?? && introspectedTable.remarks != ''>
<#list introspectedTable.remarks?split("\n") as remark>
*   ${remark}
</#list>
</#if>
* ${introspectedTable.fullyQualifiedTable}
*/
        ]]>
    </comment>

    <comment ID="addClassComment"><![CDATA[
/**
* ${introspectedTable.fullyQualifiedTable}
*/
        ]]>
    </comment>


    <comment ID="addEnumComment"><![CDATA[
/**
* ${introspectedTable.fullyQualifiedTable}
*/
        ]]>
    </comment>

    <comment ID="addInterfaceComment"><![CDATA[
/**
*  ${introspectedTable.fullyQualifiedTable}
*/
        ]]>
    </comment>


    <comment ID="addGetterComment"><![CDATA[
<#if introspectedColumn??>
/**
 * @return the value of ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 */
<#else>
/**
 * @return the value of field ${method.name?replace("get","")?replace("is", "")?uncap_first}
 */
</#if>
        ]]>
    </comment>


    <comment ID="addSetterComment"><![CDATA[
<#if introspectedColumn??>
/**
 *
 * @param ${method.parameters[0].name} the value for ${introspectedTable.fullyQualifiedTable}
    .${introspectedColumn.actualColumnName}
 *
 */
<#else>
/**
 *
 * @param ${method.parameters[0].name} the value for field ${method.name?replace("set","")?uncap_first}
 *
 */
</#if>
        ]]>
    </comment>


    <comment ID="addGeneralMethodComment"><![CDATA[
/**
*  ${introspectedTable.fullyQualifiedTable}
*/
        ]]>
    </comment>
</template>