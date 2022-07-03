package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.AgregarExperienciaCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarExperienciaUseCase extends UseCase<RequestCommand<AgregarExperienciaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarExperienciaCommand> agregarExperienciaCommandRequestCommand) {
        var command = agregarExperienciaCommandRequestCommand.getCommand();
        var bailarin = Bailarin.from(command.getBailarinId(),retrieveEvents(command.getEntityId().value()));
        bailarin.agregarExperiencia(command.getEntityId(), command.getEstilo(), command.getLugar(), command.getDuracion());
        emit().onResponse(new ResponseEvents(bailarin.getUncommittedChanges()));
    }
}
