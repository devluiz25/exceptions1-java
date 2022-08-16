package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class PrincipalReservaHotel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		char resp;

		do {
			try {
				System.out.print("NUMERO DO QUARTO PARA RESERVA: ");
				int number = sc.nextInt();
				System.out.print("CHECK-IN DATE(DD/MM/YYYY): ");
				Date checkIn = sdf.parse(sc.next());
				System.out.print("CHECK-OUT DATE(DD/MM/YYYY): ");
				Date checkOut = sdf.parse(sc.next());

				Reserva reserva = new Reserva(number, checkIn, checkOut);
				System.out.println("RESERVA: " + reserva);

				System.out.println();
				System.out.println("ENTRE PARA ATUALIZAR AS DATAS DA RESERVA:");
				System.out.print("CHECK-IN DATE(DD/MM/YYYY): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("CHECK-OUT DATE(DD/MM/YYYY): ");
				checkOut = sdf.parse(sc.next());

				reserva.updateDates(checkIn, checkOut);
				System.out.println("RESERVA: " + reserva);
			} catch (ParseException e) {
				System.out.println("FORMATO DE DATA INVALIDA!");
			} catch (DomainException e) {
				System.out.println("ERRO NA RESERVA: " + e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("NÃO PODE COLOCAR LETRAS PARA INFORMAR O QUARTO!");
			}

			System.out.println();
			System.out.print("DESEJA REINICIAR O SISTEMA: ");
			resp = sc.next().charAt(0);
		} while (resp == 's');
		sc.close();
	}

}
