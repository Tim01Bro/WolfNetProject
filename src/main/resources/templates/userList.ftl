<#import "parts/common.ftl" as c>
<@c.page>

 <h2 id="whiteText" class="funny-title">List of users</h2>

    <table cellspacing="0" id="blackText">
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th>Active</th>
            <th>Online</th>
            <th>Edit</th>
         </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roleSet as role>${role}<#sep>, </#list></td>
                <td><#if user.active>Active<#else>Not Active</#if></td>
                <td>${princ}</td>
                <td><a href="/user/${user.id}">Edit</a></td>

            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>