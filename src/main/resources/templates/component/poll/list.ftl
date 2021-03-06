<div class="ht-box">
    <div class="ht-tip">
    <#if !(pollList?size == 0)>
        Últimes enquestes creades.
    <#else>
        Cap enquesta activa.
    </#if>
    </div>
    <div class="ht-polls">
        <div class="flex-container">
            <#list pollList as poll>
            <div class="ht-poll<#if !poll.notStarted \and !poll.votingClosed> ht-active</#if>">
                <a href="/poll/${poll.id}" class="button button-ht">
                    <#if poll.description?length &gt; 25>${poll.description[0..*25]}...
                    <#else>${poll.description}
                    </#if>
                </a>
            </div>
            </#list>
        </div>
    </div>
</div>
