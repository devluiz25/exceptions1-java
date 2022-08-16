package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class PrincipalReservaHotel {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		char resp;

		do {
			System.out.print("NUMERO DO QUARTO PARA RESERVA: ");
			int number = sc.nextInt();
			System.out.print("CHECK-IN DATE(DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CHECK-OUT DATE(DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());

			if (!checkOut.after(checkIn)) {
				System.out.println("ERRO NA RESERVA, A DATA DE CHECK-OUT DEVE SER APÓS A DATA DE CHECK-IN!");
			} else {
				Reserva reserva = new Reserva(number, checkIn, checkOut);
				System.out.println("RESERVA: " + reserva);

				System.out.println();
				System.out.println("ENTRE PARA ATUALIZAR AS DATAS DA RESERVA:");
				System.out.print("CHECK-IN DATE(DD/MM/YYYY): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("CHECK-OUT DATE(DD/MM/YYYY): ");
				checkOut = sdf.parse(sc.next());

				String erro = reserva.updateDates(checkIn, checkOut);
				if (erro != null) {
					System.out.println("ERRO NA RESERVA: " + erro);
				} else {
					System.out.println("RESERVA: " + reserva);
				}
			}
			System.out.println();
			System.out.print("DESEJA REINICIAR O SISTEMA: ");
			resp = sc.next().charAt(0);
		} while (resp == 's');
		sc.close();
	}

}
