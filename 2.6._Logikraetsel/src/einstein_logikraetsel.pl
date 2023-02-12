%Einstein-Rätsel

erstes(E,[E|_]).
mittleres(M,[_,_,M,_,_]).

links(A,B,[A|[B|_]]).
links(A,B,[_|R]) :- links(A,B,R).
neben(A,B,L) :- links(A,B,L);links(B,A,L).

run :-
	X = [_,_,_,_,_],
	member([rot,brite,_,_,_],X),
	member([_,schwede,_,_,hund],X),
	member([_,daene,_,tee,_],X),
	links([gruen,_,_,_,_],[weiss,_,_,_,_],X),
	member([gruen,_,_,kaffee,_],X),
	member([_,_,banane,_,vogel],X),
	mittleres([_,_,_,milch,_],X),
	member([gelb,_,schokolade,_,_],X),
	erstes([_,norweger,_,_,_],X),
	neben([_,_,brot,_,_],[_,_,_,_,katze],X),
	neben([_,_,_,_,pferd],[_,_,schokolade,_,_],X),
	member([_,_,apfel,bier,_],X),
	neben([_,norweger,_,_,_],[blau,_,_,_,_],X),
	member([_,deutsche,kartoffeln,_,_],X),
	neben([_,_,brot,_,_],[_,_,_,wasser,_],X),
	member([_,N,_,_,fisch],X),
	write(X),nl,
	write('Der '),write(N),write(' hat einen Fisch als Haustier.'),nl.
	