<!-- Modal -->
<div class="modal fade" id="formAddAzienda" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form action="addAzienda" method="post" role="form">
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="nome" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Citta</label>
                        <input type="text" name="citta" class="form-control">
                    </div>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>
                    <button type="submit" class="btn btn-primary">
                        Aggiungi
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- End Modal -->