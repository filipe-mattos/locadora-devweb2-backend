(ns locadora.adapters.repo-memory)

(defn make-repo []
  (let [db (atom {})]
    {:save (fn [actor] (swap! db assoc (:id actor) actor))
     :find-by-id (fn [id] (get @db id))
     :_db db}))