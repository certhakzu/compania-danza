package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.AgregarClaseRealizadaCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class AgregarClaseRealizadaUseCase extends UseCase<RequestCommand<AgregarClaseRealizadaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarClaseRealizadaCommand> agregarClaseRealizadaCommandRequestCommand) {
        var command = agregarClaseRealizadaCommandRequestCommand.getCommand();
        var bailarin = Bailarin.from(command.getBailarinId(), retrieveEvents(command.getClaseId().value()));

        bailarin.agregarClaseRealizada(command.getEntityId(), command.getClaseId(), command.getFechaDeRealizacion());
        emit().onResponse(new ResponseEvents(bailarin.getUncommittedChanges()));
    }
}
