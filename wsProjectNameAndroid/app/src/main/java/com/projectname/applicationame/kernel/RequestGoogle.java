package com.projectname.applicationame.kernel;

public class RequestGoogle {
       private String command;
        private String entityName;
        private Object entity;

        public RequestGoogle() {

        }

        // Getters y setters
        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public Object getEntity() {
            return entity;
        }

        public void setEntity(Object entity) {
            this.entity = entity;
        }

}
