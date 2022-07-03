package co.com.example.compania.clase;

import co.com.example.compania.clase.commands.CrearClaseCommand;
import co.com.example.compania.clase.values.*;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.time.LocalDateTime;

public class CrearClaseUseCase extends UseCase<RequestCommand<CrearClaseCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClaseCommand> crearClaseCommandRequestCommand) {
        var command = crearClaseCommandRequestCommand.getCommand();

        var compania = new Clase(
                command.getClaseId(),
                command.getTipoDeClaseId(),
                command.getFechaProgramadaId(),
                command.getHoraDeInicio(),
                command.getHoraDeFinal(),
                command.getNombre(),
                command.getProfesor()
        );

        emit().onResponse(new ResponseEvents(compania.getUncommittedChanges()));
    }
}
