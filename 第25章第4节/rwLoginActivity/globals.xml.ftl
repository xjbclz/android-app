<?xml version="1.0"?>
<globals>
    <global id="hasNoActionBar" type="boolean" value="true" />
    <global id="isLauncher" type="boolean" value="${isNewProject?string}" />
    <global id="GenericStringArgument" type="string" value="<#if buildApi lt 19>String</#if>" />
    <globals file="../common/common_globals.xml.ftl" />
</globals>
