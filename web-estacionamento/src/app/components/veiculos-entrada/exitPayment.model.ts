import { Veiculo } from './veiculo.model';
export interface ExitPayment {
    id?: number
    vehicle?: Veiculo,
    horaSaida?: Date,
    dataSaida?: Date,
    totalPagamento?: Number 
}