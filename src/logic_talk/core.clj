(ns logic-talk.core
  ;; (:refer-clojure :exclude [==])
  (:require [clojure.core.logic :as logic]))

;; Super-simple example.  Here, answer is "unbound".
(logic/run 1 [answer]
  logic/succeed)
(logic/run 1 [answer]
  logic/fail)

;; logic/== is a "goal constructor", sometimes called "unify".
(logic/run* [answer]
  (logic/== answer 5))

;; The above basically asks, "What's the universe look like to make this
;; statement true?"

;; fresh: Like let, fresh introduces lexically-scoped logic variables.
(logic/run* [answer]
  (logic/fresh [temp]
    (logic/== temp 5)
    (logic/== answer temp)))

;; conde: A choice point between alternatives.  This resembles Clojure's cond,
;; but is different in that it represents disjunct operations.  The whole then
;; can return multiple values.
(logic/run* [answer]
  (logic/fresh [temp]
    (logic/conde
     ((logic/== temp 5)
      (logic/== answer temp))
     ((logic/== answer 6)))))

;; This is commonly used with run to specify number of answers desired.
(logic/run 2 [answer]
  (logic/fresh [temp]
    (logic/conde
     (logic/succeed)
     (logic/fail)
     ((logic/== answer 6))
     ((logic/== answer 8)))))
