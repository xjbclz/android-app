<resources>
    <#if !isNewProject>
    <string name="title_${simpleName}">${escapeXmlString(activityTitle)}</string>
    </#if>

    <!-- Strings related to login -->
    <string name="prompt_phone">请输入手机号</string>
    <string name="prompt_password">请输入密码</string>
    <string name="action_sign_in">登录</string>
    <string name="error_invalid_phone">无效的手机号</string>
    <string name="error_invalid_password">密码长度不够</string>
    <string name="error_field_required">手机号码不能为空</string>
</resources>
