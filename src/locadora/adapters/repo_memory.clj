(ns locadora.adapters.repo-memory)

(defn make-repo []
  (let [db (atom {})     ;; map of id -> entity
        next-id (atom 1)]   ;; auto-increment counter
    {:save (fn [entity]
             (let [id @next-id]          ;; get current counter
               (swap! db assoc id entity) ;; store entity with numeric ID
               (swap! next-id inc)        ;; increment counter
               (assoc entity :id id)))    ;; return entity with ID
     :find-by-id (fn [id] (get @db id))
     :find-all (fn [] @db)
     :update (fn [id new-entity]
               (when (contains? @db id)
                 (swap! db assoc id new-entity)))
     :remove (fn [id]
               (swap! db dissoc id))
     :_db db}))