mann(lenian).
frau(helga).
mann(benno).
frau(amanda).

mann(lorenz).
frau(anisa).

mann(bob).
mann(arnd).
frau(julia).

frau(swenja).
mann(caspar).
mann(markus).


vater(lorenz, lenian).
mutter(lorenz, helga).
vater(anisa, benno).
mutter(anisa, amanda).

vater(bob, lorenz).
mutter(bob, anisa).
vater(arnd, lorenz).
mutter(arnd, anisa).

vater(swenja, arnd).
mutter(swenja, julia).
vater(caspar, arnd).
mutter(caspar, julia).
vater(markus, arnd).
mutter(markus, julia).


schwester(X, Y) :-
	vater(X, Z),
	vater(Y, Z),
	frau(Y),
	not(frau(X) == frau(Y)).
	

bruder(X, Y) :-
	vater(X, Z),
	vater(Y, Z),
	mann(Y),
	not(mann(X) == mann(Y)).
	
	
grossvater(X, Y) :- % väterlicher Seits
	vater(X, Z),
	vater(Z, Y).
grossvater(X, Y) :- % mütterlicher Seits
	mutter(X, Z),
	vater(Z, Y).

grossmutter(X, Y) :- % mütterlicher Seits
	mutter(X, Z),
	mutter(Z, Y).
grossmutter(X, Y) :- % väterlicher Seits
	vater(X, Z),
	mutter(Z, Y).
	
tante(X, Y) :-
	vater(X, Z),
	schwester(Z, Y).
	
onkel(X, Y) :-
	vater(X, Z),
	bruder(Z, Y).

%Clause: Regel und Fakt