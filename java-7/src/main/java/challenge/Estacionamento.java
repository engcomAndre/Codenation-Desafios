package challenge;

import challenge.constants.Config.*;
import challenge.constants.Mensagens.*;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carroList;

    public Estacionamento() {
        this.carroList = new ArrayList<>();
    }

    public void estacionar(Carro carro) {

        validarDadosDoMotorista(carro);

        if (carroList.size() < ESTACIONAMENTO_CONFIG.QNTD_VAGAS) {
            carroList.add(carro);
        } else {

            Carro carroNSenior = buscarPrimeiraVagaNaoSenior();

            carroList.remove(carroNSenior);
            carroList.add(carro);
        }
    }

    private Carro buscarPrimeiraVagaNaoSenior() {
        return carroList.stream()
                        .filter(car -> car.getMotorista().getIdade() <  ESTACIONAMENTO_CONFIG.LIMIT_IDADE_SENIOR)
                        .findFirst()
                        .orElseThrow(() -> new EstacionamentoException(ESTACIONAMENTO.MSG_LOTADO));
    }

    private void validarDadosDoMotorista(Carro carro) {
        Motorista motorista = carro.getMotorista();

        boolean motoristaValido = motorista != null && motorista.getIdade() > ESTACIONAMENTO_CONFIG.LIMIT_IDADE_MOTORISTA && motorista.getPontos() < ESTACIONAMENTO_CONFIG.LIMIT_PONTOS_CARTEIRA;

        if (!motoristaValido)
            throw new EstacionamentoException(ESTACIONAMENTO.MOTORISTA_DADOS_INSUFICIENTES);
    }

    public int carrosEstacionados() {
        return this.carroList.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return this.carroList.contains(carro);
    }
}
