%definiciones de padres
padre(tito,pepe).
padre(pepe,paco).
padre(pepe,ana).
%definiciones de madres
madre(maria,pepe).
madre(pepa,paco).
madre(pepa,lope).
madre(pepa,kique).
%Y es padre de alguien cuyo hijo es X
%o Y es madre de alguien cuyo hijo es X
es_descendiente(X,Y):- padre(Y,_),padre(_,X);
					   madre(Y,_),madre(_X).
