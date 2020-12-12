% определить предикаты:
	% and(A,B)
	% or(A, B)
	% xor(A, B)
	% not(A)
	% equ(A,B)
% ипользовать предикат truth_table(A,B, expression) для построения таблиц истинности, например:
% truth_table(A,B,and(A,or(A,B))).
% true true true
% true fail true
% fail true fail
% fail fail fail

% Придикаты 

and(A, B) :- A, B.
or(A, B) :- A; B.
equ(A,B) :- A = B.
xor(A,B) :- A \= B.
not(A) :- \+ A.

ev(E, true) :- E, !.
ev(_, false).

bool(true).
bool(false).

truth_table(A, B, E) :-
    bool(A),
    bool(B),
    write(A),
    write('.\t '),
    write(B),
    write('.\t '),
    ev(E, Result),
    write(Result),
    write('.\n '),
    fail.

% Проверка

% truth_table(A,B,and(A,or(A,B))).
% true. true. true.
% true. fail. true.
% fail. true. fail.
% fail. fail. fail

% truth_table(A,B,xor(not(A), or(A,B))).
% true.   true.   true.
% true.   false.  true.
% false.  true.   true.
% false.  false.  true

% truth_table(A,B,or(A, not(B))).
% true.   true.   true.
% true.   false.  true.
% false.  true.   false.
% false.  false.  true.
