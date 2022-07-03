package co.com.example.compania.ensayo;

import co.com.example.compania.ensayo.commands.ActualizarDescripcionCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarDescripcionUseCase extends UseCase<RequestCommand<ActualizarDescripcionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionCommand> actualizarDescripcionCommandRequestCommand) {
        var command = actualizarDescripcionCommandRequestCommand.getCommand();

        var ensayo = Ensayo.from(command.getEnsayoId(), repository().getEventsBy(command.getEnsayoId().value()));

        ensayo.actualizarDescripcion(command.getDescripcion());
        emit().onResponse(new ResponseEvents(ensayo.getUncommittedChanges()));
    }
}
