%porcentajes de evaluacion indicadores de gestion de puesto
%actividdades cumplimiento 5
regla1(X):- X>=91,X=<100.
%actividades cumplimiento 4
regla2(X):- X>=81,X=<90.
%actividades cumplimiento 3
regla3(X):- X>=71,X=<80.
%actividaes cumplimiento 2
regla4(X):- X>=61,X=<70.
%actividades cumplimiento 1
regla5(X):- X=<60.


%ESCALAS pARA EVALUAR CONOCIMIENTOS
regla6('Sobresaliente').
regla7('Muy Buena').
regla8('Bueno').
regla9('Regular').
regla10('Insuficiente').
esrespuestacono(X,5):-regla6(X).
esrespuestacono(X,4):-regla7(X).
esrespuestacono(X,3):-regla8(X).
esrespuestacono(X,2):-regla9(X).
esrespuestacono(X,1):-regla10(X).

%ESCALAS PARA EVALUAR COMPETENCIAS TECNICAS
regla16('Altamente Desarrollada').
regla17('Desarrolada').
regla18('Medianamente Desarrollada').
regla19('Poco Desarrollada').
regla20('No Desarrollada').
esrespuesta1(X,5):-regla16(X).
esrespuesta2(X,4):-regla17(X).
esrespuesta3(X,3):-regla18(X).
esrespuesta4(X,2):-regla19(X).
esrespuesta5(X,1):-regla20(X).


%ESCALAS PARA EVALUAR COMPETENCIAS UNIVERSALES Y TRABAJO, INICIATIVA
regla26('Siempre').
regla27('Fecuentemente').
regla28('Algunas veces').
regla29('Rara vez').
regla30('Nunca').
esrespuestae1(X,5):-regla26(X).
esrespuestae2(X,4):-regla27(X).
esrespuestae3(X,3):-regla28(X).
esrespuestae4(X,2):-regla29(X).
esrespuestae5(X,1):-regla30(X).

%ESCALAS DE CALIFICACION DE LOS RESULTADOS

califResult(X,'Excelente'):-X>=(90.5),X=<100.
califResult(X,'Muy Bueno'):-X>=80.5,X=<90.4.
califResult(X,'Satisfactorio'):-X>=70.5,X=<80.4.
califResult(X,'Deficiente'):-X>=60.5,X=<70.4.
califResult(X,'Inaceptable'):-X=<60.4.

%porcentajes de conocimientos

esrespuestac(X,'Sobresaliente'):-X>=(80).
esrespuestac(X,'Muy Buena'):-X>=60,X=<79.
esrespuestac(X,'Buena'):-X>=40,X=<59.
esrespuestac(X,'Regular'):-X>=20,X=<39.
esrespuestac(X,'Iregular'):-X=<(19).

%PORCNTAJES DE COMPETENCIAS TECNICAS

esrespuestact(X,'Altamente Desarrollada'):-X>=(80).
esrespuestact(X,'Desarrollada'):-X>=60,X=<79.
esrespuestact(X,'Medianamente Desarrollada'):-X>=40,X=<59.
esrespuestact(X,'Poco Desarrollada'):-X>=20,X=<39.
esrespuestact(X,'No Desarrollada'):-X=<(19).

%PORCENTAJES DE COMPETENCIAS UNIVERSALES

esrespuestacu(X,'Siempre'):-X>=(80).
esrespuestacu(X,'Frecuentemente'):-X>=60,X=<79.
esrespuestacu(X,'Alguna vez'):-X>=40,X=<59.
esrespuestacu(X,'Rara vez'):-X>=20,X=<39.
esrespuestacu(X,'Nunca'):-X=<(19).
