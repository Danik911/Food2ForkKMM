package com.example.food2forkkmm.android.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.food2forkkmm.domain.model.NegativeAction
import com.example.food2forkkmm.domain.model.PositiveAction

@Composable
fun GenericDialog(
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)?,
    title: String,
    description: String? = null,
    positiveAction: PositiveAction?,
    negativeAction: NegativeAction?,
    onRemoveHeadQueue: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onDismiss?.invoke()
            onRemoveHeadQueue()
        },
        text = {
            if (description != null) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.body1
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h3
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                if (negativeAction != null) {
                    Button(
                        modifier = Modifier.padding(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.onError
                        ),
                        onClick = {
                            negativeAction.onNegativeAction()
                            onRemoveHeadQueue()
                        }) {
                        Text(
                            text = negativeAction.negativeBtnTxt,
                            style = MaterialTheme.typography.button
                        )

                    }
                }
                if (positiveAction != null) {
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = {
                            positiveAction.onPositiveAction()
                            onRemoveHeadQueue()
                        }
                    ) {
                        Text(
                            text = positiveAction.positiveBtnTxt,
                            style = MaterialTheme.typography.button
                        )

                    }
                }

            }

        }

    )


}