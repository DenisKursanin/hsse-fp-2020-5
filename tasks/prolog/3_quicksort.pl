% Определить предикат qsort(L, K) который для заданного списка целых чисел возвращает отсортированный 

qsort([],[]).
qsort([H|T], K):-
	pivot(H,T,L1,L2),
        qsort(L1,S1),
        qsort(L2,S2),
	append(S1,[H|S2], K).

pivot(_,[],[],[]).
pivot(H,[X|T],[X|L],G):-
    X=<H,
    pivot(H,T,L,G).
pivot(H,[X|T],L,[X|G]):-
    X>H,
    pivot(H,T,L,G).
    
% Проверка
% [3]  ?- qsort([2,1,30,3,89,34,19,74,63], X).
% X = [1, 2, 3, 19, 30, 34, 63, 74, 89] 
