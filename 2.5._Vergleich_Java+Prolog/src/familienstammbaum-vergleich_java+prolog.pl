mann(lenian).
mann(benno).

mann(lorenz).

mann(bob).
mann(arnd).

mann(caspar).
mann(markus).


vater(lorenz, lenian).
mutter(lorenz, helga).


vater(bob, lorenz).
mutter(bob, anisa).
vater(arnd, lorenz).
mutter(arnd, anisa).


vater(caspar, arnd).
mutter(caspar, julia).
vater(markus, arnd).
mutter(markus, julia).


bruder(X, Y) :-
	vater(X, Z),
	vater(Y, Z),
	not(mann(X) == mann(Y)).
	
	
grossvater(X, Y) :- % väterlicher Seits
	vater(X, Z),
	vater(Z, Y).
grossvater(X, Y) :- % mütterlicher Seits
	mutter(X, Z),
	vater(Z, Y).

	
onkel(X, Y) :-
	vater(X, Z),
	bruder(Z, Y).