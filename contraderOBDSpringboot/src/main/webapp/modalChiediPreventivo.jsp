<c:if test="${errore == 'ok'}">
    <c:set var="testo" value="Richiesta preventivo per soluzione errore" />
</c:if>
<c:if test="${scadenze == 'revisione'}">
    <c:set var="testo" value="Richiesta preventivo per revisione" />
</c:if>
<c:if test="${errore == 'tegliando'}">
    <c:set var="testo" value="Richiesta preventivo per tagliando" />
</c:if>

<!-- Modal -->
<div class="modal fade" id="formChiediPreventivo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form action="chiediPreventivo" method="post" role="form">
                    <div class="row">
                        <div class="form-group">
                            <input type="hidden" name="codDispositivo" value="${viewAuto.codDispositivo}" class="form-control">
                            <input type="hidden" name="idOfficina" value="${viewAuto.officinaEntity.idOfficina}" class="form-control">
                            <input type="hidden" name="idDriver" value="${viewAuto.driverEntity.idDriver}" class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label>Descrizione</label>
                                <textarea class="form-control" name="descrizione">${testo}</textarea>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>
                    <button type="submit" class="btn btn-primary">
                        Richiedi preventivo
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- End Modal -->