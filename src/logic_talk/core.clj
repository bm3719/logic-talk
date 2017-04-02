(ns logic-talk.core
  ;; (:refer-clojure :exclude [==])
  (:require [clojure.core.logic :as logic]))

;; logic/== is a "goal constructor".

(logic/run* [answer]
  (logic/== answer 5))
