(ns locadora.domain.actor)

(defn create-actor [name]
  (let [actor {:name name}]
    {:actor actor
     :actions [[:save :actor actor]]}))

(defn read-actors []
  {:actions [[:find-all :actor]]})

(defn read-actor [id]
  {:actions [[:find-by-id :actor id]]})

(defn update-actor [id data]
  (let [actor (assoc data :id id)]
    {:actor actor
     :actions [[:update :actor id actor]]}))

(defn remove-actor [id]
  {:actions [[:remove :actor id]]})