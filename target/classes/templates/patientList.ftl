<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <@l.logout/>
<h1>Patient List</h1>
<table>
    <#list patients as patient>
        <p><a href="/card/${patient.id}">${patient.name} ${patient.surname} ${patient.patronymic}</a> <a href="/delete/${patient.id}">Delete a patient</a>></p>
    </#list>
    <a href="/addPatient"><p>Add new patient with card</p></a>
</table>
</@c.page>