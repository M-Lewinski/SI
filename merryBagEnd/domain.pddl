(define
	(domain merry)
	(:requirements :adl)
	(:types hobbit ball room kolor box number)
	(:constants czerwony niebieski zolty rozowy zielony - kolor box1 box2 box3 box4 box5 box6 box7 box8 box9 - box num1 num2 num3 num4 num5 num6 num7 num8 pusty - number)
	
	(:predicates
		(at ?x ?r)
		(have ?b)
		(door ?r1 ?r2 - room ?k - kolor)
		(exit ?r - room)
		(color ?b - ball ?k - kolor)
		
		(puzzle ?r - room)
		(solved ?r - room)
		(adjacent ?b1 ?b2 - box)
		(numbered ?b - box ?n - number) 
	)
	
	(:action idz
		:parameters (?h - hobbit ?r1 ?r2 - room ?b - ball)
		:precondition
			(and
				(at ?h ?r1)
				(exists (?k - kolor) (and (have ?b) (color ?b ?k) (door ?r1 ?r2 ?k) ) )
			)
		:effect
			(and
				(not (at ?h ?r1))
				(not (have ?b))
				(at ?h ?r2)
			)
	)
	(:action wez
		:parameters (?h - hobbit ?r1 - room ?b - ball)
		:precondition
			(and
				(at ?h ?r1)
				(at ?b ?r1)
			)
		:effect
			(and
				(not (at ?b ?r1))
				(have ?b)
			)
		)
	(:action rozwiaz
		:parameters (?h - hobbit ?r - room)
		:precondition
			(and
				(at ?h ?r)
				(puzzle ?r)
				(numbered box1 num1)
				(numbered box2 num2)
				(numbered box3 num3)
				(numbered box4 num4)
				(numbered box5 num5)
				(numbered box6 num6)
				(numbered box7 num7)
				(numbered box8 num8)
				(numbered box9 pusty)
				
			)
		:effect
			(and
				(solved ?r)
				(not (puzzle ?r))
			)
	)
	(:action ruszKlocek
		:parameters (?h - hobbit ?r - room ?b1 ?b2 - box ?nm1 - number)
		:precondition
			(and
				(at ?h ?r)
				(puzzle ?r)
				(numbered ?b1 ?nm1)
				(numbered ?b2 pusty)
				(adjacent ?b1 ?b2)		
			)
		:effect
			(and
				(not(numbered ?b1 ?nm1))
				(not(numbered ?b2 pusty))
				(numbered ?b1 pusty)
				(numbered ?b2 ?nm1)
			)
	)
)