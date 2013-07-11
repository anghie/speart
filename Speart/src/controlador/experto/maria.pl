%Posibles porcentajes
porcentajeCumple(X) :- X>=91,
					   X=<100.
regla6('Sobresaliente').
regla7('Muy Buena').
regla8(X,5):-regla6(X).
regla9(X,4):-regla7(X).
