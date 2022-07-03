package co.com.example.compania.ensayo;

import co.com.example.compania.ensayo.commands.CrearEnsayoCommand;
import co.com.example.compania.ensayo.values.*;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.time.LocalDateTime;

public class CrearEnsayoUseCase extends UseCase<RequestCommand<CrearEnsayoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEnsayoCommand> crearEnsayoCommandRequestCommand) {
        var command = crearEnsayoCommandRequestCommand.getCommand();

        var compania = new Ensayo(
                EnsayoId.of("qqq"),
                FechaProgramadaId.of("www"),
                ObraId.of("eee"),
                new HoraDeInicio(LocalDateTime.MIN),
                new HoraDeFinal(LocalDateTime.MAX),
                new Descripcion("rrrrrrrrrrrrrrrrrrr")
        );

        emit().onResponse(new ResponseEvents(compania.getUncommittedChanges()));
    }
}
