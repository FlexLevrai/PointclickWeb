import {Injectable} from "@angular/core";
import {MatDialog} from "@angular/material/dialog";
import {MatConfirmDialogComponent} from "../app/mat-confirm-dialog/mat-confirm-dialog.component";
import {ToastrService} from "ngx-toastr";

@Injectable({providedIn:"root"})
export class NotificationService {

  constructor(private toastr: ToastrService, private dialog: MatDialog) {}

  onpenConfirmDialog(msg)
  {
    return this.dialog.open(MatConfirmDialogComponent, {
      width: '500px',
      disableClose: true,
      data: {
        message: msg
      }
    });
  }

  successNotification(message)
  {
    this.toastr.success(message,' TotalSoftware Valider')
  }

  errorNotification(message)
  {
    this.toastr.error(message, ' TotalSoftware Erreur');
  }

  infoNotification(message)
  {
    this.toastr.info(message, ' TotalSoftware Information');
  }

  warningNotification(message)
  {
    this.toastr.warning(message, ' TotalSoftware Avertissement');
  }

}
