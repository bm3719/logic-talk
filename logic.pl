% -*- mode: prolog -*-

sunny.






killed(me, slug).
killed(me, warthog).
killed(me, mole-rat).

human(me).
human(gary).

ugly(slug).
ugly(warthog).
ugly(mole-rat).
ugly(gary).
ugly(me).
cute(cat).

murderer(Suspect) :- killed(Suspect, Victim), human(Victim).










%% killed(me, gary).

%% killed(me, cat).

%% murderer(Suspect) :- killed(Suspect, Victim),
%%                      (human(Victim) ; cute(Victim)).

%% killed(me, me).

% What do we do here?


%% factorial (+N:int, ?FacN:int)
%
% computes FacN as factorial of N.
% N! = N * (N - 1)!
% 0! = 1
%
% @param N input integer
% @param FactN result of the computation

factorial(0, 1).
factorial(N, FacN) :- N > 0,
                      DecN is N - 1,
                      factorial(DecN, DecFacN),
                      FacN is N * DecFacN.
