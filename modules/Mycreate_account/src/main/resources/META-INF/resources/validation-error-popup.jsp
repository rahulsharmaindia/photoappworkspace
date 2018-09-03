<style>
#responsive{
display: none;
}
.modal-dialog {
    position: relative!important;
    top:40px;
}
.modal-content {
    overflow: hidden;
    margin-left: 6%;
}
</style>

<div id="responsive" class="modal fade in">
    <div class="modal-dialog">
        <div class="modal-content" style="height:190px!important;">
            <div style="background-color:#47647a;" class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="title-model">ERROR!!!</h3>
            </div>
            <div class="modal-body" id="modalbody">
                <p>Default Text</p>	                
            </div>
            <div style="background-color:#47647a; text-align:center;" class="modal-footer">
                <button id="createActBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>                         