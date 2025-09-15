(ns locadora.domain.actor)

(defn create-actor [name]
  (let [actor {:id (str (random-uuid))
               :name name}]
    {:actor actor
     :actions [[:save actor]]}))