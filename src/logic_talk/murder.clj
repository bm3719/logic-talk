(ns logic-talk.murder
  ;;  (:refer-clojure :exclude [==])
  (:require [clojure.core.logic :as logic]
            [clojure.core.logic.pldb :as pldb]))

(pldb/db-rel killed p1 p2)
(pldb/db-rel human p)
(pldb/db-rel ugly p)
(pldb/db-rel cute p)

(def facts
  (pldb/db
   [killed 'me 'slug]
   [killed 'me 'warthog]
   [killed 'me 'mole-rat]
   [killed 'me 'gary]

   [human 'me]
   [human 'gary]

   [ugly 'slug]
   [ugly 'warthog]
   [ugly 'mole-rat]
   [ugly 'gary]
   [ugly 'me]
   [cute 'cat]))

(pldb/with-db facts
  (logic/run* [q]
    (cute q)))

;; Murderers
(pldb/with-db facts
  (logic/run* [q]
    (logic/fresh [h]
      (human h)
      (killed q h))))
