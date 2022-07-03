package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.CrearBailarinCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearBailarinUseCase extends UseCase<RequestCommand<CrearBailarinCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearBailarinCommand> crearBailarinCommandRequestCommand) {
        var command = crearBailarinCommandRequestCommand.getCommand();

        var compania = new Bailarin(
                command.getEntityId(),
                command.getNombre(),
                command.getTelefono(),
                command.getEmail()
        );

        emit().onResponse(new ResponseEvents(compania.getUncommittedChanges()));
    }
}
